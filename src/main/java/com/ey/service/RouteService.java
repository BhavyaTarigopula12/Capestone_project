package com.ey.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ey.dto.request.AddStopsRequest;
import com.ey.dto.request.CreateRouteRequest;
import com.ey.dto.request.UpdateFareRequest;
import com.ey.dto.response.RouteResponse;
import com.ey.dto.response.StopsResponse;
import com.ey.mapper.RouteMapper;
import com.ey.mapper.StopMapper;
import com.ey.model.Route;
import com.ey.repository.RouteRepository;
import com.ey.repository.RouteStopRepository;

@Service
public class RouteService {

    private static final Logger log = LoggerFactory.getLogger(RouteService.class);

    private final RouteRepository routeRepository;
    private final RouteStopRepository stopRepository;

    public RouteService(RouteRepository routeRepository, RouteStopRepository stopRepository) {
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
    }

    public RouteResponse createRoute(CreateRouteRequest request) {

        log.info("Creating route from {} to {}", request.getFromLocation(), request.getToLocation());

        Route route = RouteMapper.toEntity(request);
        route = routeRepository.save(route);

        return RouteMapper.toResponse(route);
    }

    public StopsResponse addStops(Long routeId, AddStopsRequest request) {

        log.info("Adding stops for routeId={}", routeId);

        var stops = StopMapper.toEntities(request, routeId);
        var saved = stopRepository.saveAll(stops);

        return new StopsResponse(saved.size(), routeId);
    }

    public RouteResponse getRoute(Long routeId) {

        log.info("Fetching route routeId={}", routeId);

        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new IllegalArgumentException("Route not found"));

        return RouteMapper.toResponse(route);
    }

    public void updateFare(Long routeId, UpdateFareRequest request) {

        log.info("Updating fare for routeId={}", routeId);

        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new IllegalArgumentException("Route not found"));

        RouteMapper.applyFarePatch(request, route);
        routeRepository.save(route);
    }
}
