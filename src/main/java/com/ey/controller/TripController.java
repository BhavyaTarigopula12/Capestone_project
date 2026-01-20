package com.ey.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.dto.request.CreateTripRequest;
import com.ey.dto.request.CurrentStopRequest;
import com.ey.dto.request.UpdateTripStatusRequest;
import com.ey.dto.response.CurrentStopResponse;
import com.ey.dto.response.TripResponse;
import com.ey.dto.response.UpdateTripStatusResponse;
import com.ey.service.TripService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/trips")
@Validated
public class TripController {
	private TripService tripService;

	public TripController(TripService tripService) {
		this.tripService = tripService;
	}

	@PostMapping
	public ResponseEntity<TripResponse> createTrip(@Valid @RequestBody CreateTripRequest request) {
		TripResponse resp = tripService.createTrip(request);
		return ResponseEntity.status(201).body(resp);
	}

	@PatchMapping("/{tripId}/status")
	public ResponseEntity<UpdateTripStatusResponse> updateTripStatus(@PathVariable Long tripId,
			@Valid @RequestBody UpdateTripStatusRequest request) {
		return ResponseEntity.ok(tripService.updateStatus(tripId, request));
	}

	@PostMapping("/{tripId}/current-stop")
	public ResponseEntity<CurrentStopResponse> reportCurrentStop(@PathVariable Long tripId,
			@Valid @RequestBody CurrentStopRequest request) throws Throwable {
		return ResponseEntity.ok(tripService.reportCurrentStop(request));
	}

	@GetMapping("/{tripId}")
	public ResponseEntity<TripResponse> getTrip(@PathVariable Long tripId) {
		return ResponseEntity.ok(tripService.getTrip(tripId));
	}

	@GetMapping("/{tripId}/stops")
	public ResponseEntity<Object> getTripStops(@PathVariable Long tripId) {
		return ResponseEntity.ok(tripService.getStopsForTrip(tripId));
	}
	@GetMapping
	public ResponseEntity<List<TripResponse>> getAllTrips() {
	    return ResponseEntity.ok(tripService.getAllTrips());
	}

	@GetMapping("/status/{status}")
	public ResponseEntity<List<TripResponse>> getTripsByStatus(@PathVariable String status) {
	    return ResponseEntity.ok(tripService.getTripsByTripStatus(status));
	}


}
