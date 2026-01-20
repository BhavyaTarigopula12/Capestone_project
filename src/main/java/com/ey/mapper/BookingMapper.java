package com.ey.mapper;

import java.time.LocalDateTime;

import com.ey.dto.request.BookingRequest;
import com.ey.dto.response.BookingResponse;
import com.ey.dto.response.TripSummary;
import com.ey.model.Booking;
import com.ey.model.RouteStop;
import com.ey.model.Trip;
public class BookingMapper {

    public static Booking toEntity(
            BookingRequest req,
            Long userId,
            double fare,
            String status
    ) {
        return new Booking(
                null,
                req.getTripId(),
                userId,
                req.getPickupStopId(),
                req.getDropStopId(),
                fare,
                status
        );
    }

    public static BookingResponse toResponse(
            Booking booking,
            Trip trip,
            RouteStop pickupStop
    ) {

        LocalDateTime pickupTime = null;

        if (trip != null &&
            trip.getTripDate() != null &&
            pickupStop != null &&
            pickupStop.getPickupTime() != null) {

            pickupTime =
                trip.getTripDate().atTime(pickupStop.getPickupTime());
        }

        TripSummary summary = new TripSummary(
                trip.getTripId(),
                trip.getRouteId(),
                trip.getTripDate(),
                trip.getTripStatus()
        );

        return new BookingResponse(
                booking.getBookingId(),
                booking.getStatus(),
                booking.getFare(),
                pickupTime,
                summary
        );
    }
}

