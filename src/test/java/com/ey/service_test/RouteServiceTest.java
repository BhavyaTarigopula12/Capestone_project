package com.ey.service_test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ey.dto.request.AddStopsRequest;
import com.ey.dto.request.CreateRouteRequest;
import com.ey.dto.request.StopDto;
import com.ey.dto.request.UpdateFareRequest;
import com.ey.dto.response.RouteResponse;
import com.ey.dto.response.StopsResponse;
import com.ey.service.RouteService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class RouteServiceTest {

    @Autowired
    private RouteService routeService;

    @Test
    void testCreateRouteSuccess() {

        CreateRouteRequest request = new CreateRouteRequest();
        request.setFromLocation("Saravanampatti");
        request.setToLocation("Gandhipuram");
        request.setDistance(12.5);
        request.setFarePricePerKm(5.0);

        RouteResponse response = routeService.createRoute(request);

        assertThat(response.getRouteId()).isNotNull();
        assertEquals("Saravanampatti", response.getFromLocation());
    }

    @Test
    void testAddStopsSuccess() {

        CreateRouteRequest routeReq = new CreateRouteRequest();
        routeReq.setFromLocation("Saravanampatti");
        routeReq.setToLocation("Ukkadam");
        routeReq.setDistance(15.0);
        routeReq.setFarePricePerKm(6.0);

        RouteResponse route = routeService.createRoute(routeReq);

        StopDto s1 = new StopDto();
        s1.setStopName("Saravanampatti");
        s1.setSequenceNumber(1);
        s1.setDistanceFromStart(0.0);
        s1.setPickupTime(java.time.LocalTime.of(9, 0));

        StopDto s2 = new StopDto();
        s2.setStopName("Gandhipuram");
        s2.setSequenceNumber(2);
        s2.setDistanceFromStart(6.0);
        s2.setPickupTime(java.time.LocalTime.of(9, 30));

        AddStopsRequest stopsRequest = new AddStopsRequest();
        stopsRequest.setStops(List.of(s1, s2));

        StopsResponse response = routeService.addStops(route.getRouteId(), stopsRequest);

        assertEquals(2, response.getCreated());
    }

    @Test
    void testUpdateFareSuccess() {

        CreateRouteRequest request = new CreateRouteRequest();
        request.setFromLocation("Saravanampatti");
        request.setToLocation("Peelamedu");
        request.setDistance(10.0);
        request.setFarePricePerKm(4.0);

        RouteResponse route = routeService.createRoute(request);

        UpdateFareRequest fareRequest = new UpdateFareRequest();
        fareRequest.setFarePricePerKm(6.0);

        routeService.updateFare(route.getRouteId(), fareRequest);

        RouteResponse updated = routeService.getRoute(route.getRouteId());
        assertEquals(6.0, updated.getFarePricePerKm());
    }
}
