package com.ey.mapper;

import com.ey.dto.request.CreateTripRequest;
import com.ey.dto.request.UpdateTripStatusRequest;
import com.ey.dto.response.TripResponse;
import com.ey.dto.response.TripSummary;
import com.ey.model.Driver;
import com.ey.model.Trip;

public class TripMapper {

    public static Trip toEntity(CreateTripRequest req, Long totalSeats,Driver driver) {

        return new Trip(
            null,
            req.getRouteId(),
            req.getTripDate(),
            req.getStartTime(),
            totalSeats,      
            0L,
            "SCHEDULED",
            driver
        );
    }

    public static TripResponse todetailedResponse(Trip trip, Long driverId, String vehicleNumber) {
        return new TripResponse(
            trip.getTripId(),
            trip.getRouteId(),
            trip.getTripDate(),
            trip.getStartTime(),
            vehicleNumber,
            driverId,
            trip.getTripStatus()
        );
    }
    public static TripResponse toResponse(Trip trip) {
        return new TripResponse(
            trip.getTripId(),
            trip.getRouteId(),
            trip.getTripDate(),
            trip.getStartTime(),
            trip.getDriver().getVehicleNumber(),
            trip.getDriver().getDriverId(),
            trip.getTripStatus()
        );
    }
    public static void applyStatusPatch(UpdateTripStatusRequest req, Trip trip) {
    	if(req !=null && trip !=null ) { 
    		trip.setTripStatus(req.getTripStatus()); 
    		} 
    	} 
    public static TripSummary toSummary(Trip trip) { 
    	return new TripSummary( 
    			trip.getTripId(), 
    			trip.getRouteId(), 
    			trip.getTripDate(),
    			trip.getTripStatus()
    			); 
    	} 
    }
