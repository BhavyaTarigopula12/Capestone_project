package com.ey.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ey.dto.request.BookingRequest;
import com.ey.dto.response.BookingResponse;
import com.ey.mapper.BookingMapper;
import com.ey.model.Booking;
import com.ey.model.RouteStop;
import com.ey.model.Trip;
import com.ey.repository.BookingRepository;
import com.ey.repository.RouteStopRepository;
import com.ey.repository.TripRepository;

@Service
public class BookingService {

    private static final Logger log = LoggerFactory.getLogger(BookingService.class);

    private final TripRepository tripRepository;
    private final RouteStopRepository routeStopRepository;
    private final BookingRepository bookingRepository;

    public BookingService(
            TripRepository tripRepository,
            RouteStopRepository routeStopRepository,
            BookingRepository bookingRepository) {
        this.tripRepository = tripRepository;
        this.routeStopRepository = routeStopRepository;
        this.bookingRepository = bookingRepository;
    }

    public BookingResponse createBooking(BookingRequest request, Long userId) {

        log.info("Creating booking for userId={}, tripId={}", userId, request.getTripId());

        Trip trip = tripRepository.findById(request.getTripId())
                .orElseThrow(() -> new IllegalArgumentException("Trip not found"));

        RouteStop pickupStop = routeStopRepository.findByStopId(request.getPickupStopId())
                .orElseThrow(() -> new IllegalArgumentException("Pickup stop not found"));

        double fare = 100.0;

        Booking booking = BookingMapper.toEntity(request, userId, fare, "CONFIRMED");
        booking = bookingRepository.save(booking);

        log.info("Booking created with bookingId={}", booking.getBookingId());

        return BookingMapper.toResponse(booking, trip, pickupStop);
    }

    public BookingResponse getBooking(Long bookingId) {

        log.info("Fetching booking with bookingId={}", bookingId);

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        Trip trip = tripRepository.findById(booking.getTripId())
                .orElseThrow(() -> new IllegalArgumentException("Trip not found"));

        RouteStop pickupStop = routeStopRepository.findByStopId(booking.getPickupStopId())
                .orElseThrow(() -> new IllegalArgumentException("Pickup stop not found"));

        return BookingMapper.toResponse(booking, trip, pickupStop);
    }
}