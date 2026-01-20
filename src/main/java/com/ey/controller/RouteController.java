
package com.ey.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.dto.request.AddStopsRequest;
import com.ey.dto.request.CreateRouteRequest;
import com.ey.dto.request.UpdateFareRequest;
import com.ey.dto.response.RouteResponse;
import com.ey.dto.response.StopsResponse;
import com.ey.service.RouteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/routes")
@Validated
public class RouteController {
	private RouteService routeService;

	public RouteController(RouteService routeService) {
		this.routeService = routeService;
	}

	@PostMapping
	public ResponseEntity<RouteResponse> createRoute(@Valid @RequestBody CreateRouteRequest request) {
		RouteResponse resp = routeService.createRoute(request);
		return ResponseEntity.status(201).body(resp);
	}

	@PostMapping("/{routeId}/stops")
	public ResponseEntity<StopsResponse> addStops(@PathVariable Long routeId,
			@Valid @RequestBody AddStopsRequest request) {
		StopsResponse resp = routeService.addStops(routeId, request);
		return ResponseEntity.status(201).body(resp);
	}
	@PatchMapping("/{routeId}/fare")
	public ResponseEntity<Void> updateFare(@PathVariable Long routeId, @Valid @RequestBody UpdateFareRequest request) {
		routeService.updateFare(routeId, request);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{routeId}")
	public ResponseEntity<RouteResponse> getRoute(@PathVariable Long routeId) {
		return ResponseEntity.ok(routeService.getRoute(routeId));
	}
}
