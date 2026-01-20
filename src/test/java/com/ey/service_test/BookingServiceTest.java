package com.ey.service_test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ey.dto.request.BookingRequest;
import com.ey.dto.response.BookingResponse;
import com.ey.model.Route;
import com.ey.model.RouteStop;
import com.ey.model.Trip;
import com.ey.repository.BookingRepository;
import com.ey.repository.RouteRepository;
import com.ey.repository.RouteStopRepository;
import com.ey.repository.TripRepository;
import com.ey.service.BookingService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteStopRepository stopRepository;

    @Autowired
    private BookingRepository bookingRepository;

    private Trip trip;
    private RouteStop stop;

    @BeforeEach
    void setup() {

        Route route = new Route(null, "Saravanampatti", "Gandhipuram", 12.5, 5.0);
        route = routeRepository.save(route);

        stop = new RouteStop();
        stop.setRouteId(route.getRouteId());
        stop.setStopName("Saravanampatti");
        stop.setSequenceNumber(1);
        stop.setDistanceFromStart(0.0);
        stop.setPickupTime(java.time.LocalTime.of(9, 0));
        stop = stopRepository.save(stop);

        trip = new Trip();
        trip.setRouteId(route.getRouteId());
        trip.setTripDate(LocalDate.now());
        trip.setTripStatus("SCHEDULED");
        trip.setTotalSeats(40L);
        trip.setBookedSeats(0L);
        trip = tripRepository.save(trip);
    }

    @Test
    void testCreateBookingSuccess() {

        BookingRequest request = new BookingRequest();
        request.setTripId(trip.getTripId());
        request.setPickupStopId(stop.getStopId());
        request.setDropStopId(stop.getStopId());

        BookingResponse response = bookingService.createBooking(request, 1L);

        assertThat(response.getBookingId()).isNotNull();
        assertEquals("CONFIRMED", response.getStatus());
    }

    @Test
    void testGetBookingSuccess() {

        BookingRequest request = new BookingRequest();
        request.setTripId(trip.getTripId());
        request.setPickupStopId(stop.getStopId());
        request.setDropStopId(stop.getStopId());

        BookingResponse created = bookingService.createBooking(request, 1L);

        BookingResponse fetched = bookingService.getBooking(created.getBookingId());

        assertEquals(created.getBookingId(), fetched.getBookingId());
    }
}
