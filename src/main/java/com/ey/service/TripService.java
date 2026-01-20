package com.ey.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ey.dto.request.CreateTripRequest;
import com.ey.dto.request.CurrentStopRequest;
import com.ey.dto.request.UpdateTripStatusRequest;
import com.ey.dto.response.CurrentStopResponse;
import com.ey.dto.response.TripResponse;
import com.ey.dto.response.UpdateTripStatusResponse;
import com.ey.mapper.TripMapper;
import com.ey.model.Driver;
import com.ey.model.Trip;
import com.ey.model.Vehicle;
import com.ey.repository.DriverRepository;
import com.ey.repository.RouteStopRepository;
import com.ey.repository.TripRepository;
import com.ey.repository.VehicleRepository;

@Service
public class TripService {

    private static final Logger log = LoggerFactory.getLogger(TripService.class);

    private final TripRepository tripRepository;
    private final RouteStopRepository stopRepository;
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepo;

    public TripService(
            TripRepository tripRepository,
            RouteStopRepository stopRepository,
            VehicleRepository vehicleRepository,
            DriverRepository driverRepo) {
        this.tripRepository = tripRepository;
        this.stopRepository = stopRepository;
        this.vehicleRepository = vehicleRepository;
        this.driverRepo=driverRepo;
    }

    public TripResponse createTrip(CreateTripRequest request) {

        log.info("Creating trip for routeId={}", request.getRouteId());

        Vehicle vehicle = vehicleRepository
                .findByVehicleNumber(request.getVehicleNumber())
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));

        Long totalSeats = (long) vehicle.getSeats();
        
        Driver driver= driverRepo.findById(request.getDriverId()).orElseThrow(()-> new RuntimeException("Driver not find"));

        Trip trip = TripMapper.toEntity(request, totalSeats, driver);
        trip = tripRepository.save(trip);

        return TripMapper.todetailedResponse(
                trip,
                trip.getDriver().getDriverId(),
                trip.getDriver().getVehicleNumber()
        );
    }

    public UpdateTripStatusResponse updateStatus(Long tripId, UpdateTripStatusRequest request) {

        log.info("Updating trip status for tripId={}", tripId);

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new IllegalArgumentException("Trip not found"));

        TripMapper.applyStatusPatch(request, trip);
        tripRepository.save(trip);

        return new UpdateTripStatusResponse(
                trip.getTripId(),
                trip.getTripStatus(),
                java.time.LocalDateTime.now()
        );
    }

    public CurrentStopResponse reportCurrentStop(CurrentStopRequest request) {

        log.info("Reporting current stop stopId={}", request.getStopId());

        stopRepository.findByStopId(request.getStopId())
                .orElseThrow(() -> new IllegalArgumentException("Stop not found"));

        return new CurrentStopResponse(true);
    }

    public TripResponse getTrip(Long tripId) {

        log.info("Fetching trip tripId={}", tripId);

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new IllegalArgumentException("Trip not found"));

        return TripMapper.todetailedResponse(trip, tripId, null);
    }

    public Object getStopsForTrip(Long tripId) {
        log.info("Fetching stops for tripId={}", tripId);
        return null;
    }
    public List<TripResponse> getAllTrips() {
        return tripRepository.findAll()
                .stream()
                .map(TripMapper::toResponse)
                .toList();
    }

    public List<TripResponse> getTripsByTripStatus(String status) {
    	return tripRepository.findByTripStatus(status)
    			.stream()
                .map(TripMapper::toResponse)
    			.toList();

}
}
