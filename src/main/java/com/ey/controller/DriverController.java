package com.ey.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.dto.request.CreateDriverRequest;
import com.ey.dto.response.DriverResponse;
import com.ey.service.DriverService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/drivers")
@Validated
public class DriverController {
	private DriverService driverService;

	public DriverController(DriverService driverService) {
		this.driverService = driverService;
	}

	@PostMapping
	public ResponseEntity<DriverResponse> createDriver(@Valid @RequestBody CreateDriverRequest request) {
		DriverResponse resp = driverService.createDriver(request);
		return ResponseEntity.status(201).body(resp);
	}

	@GetMapping("/{driverId}")
	public ResponseEntity<DriverResponse> getDriver(@PathVariable Long driverId) {
		return ResponseEntity.ok(driverService.getDriver(driverId));
	}
	@GetMapping
	public ResponseEntity<List<DriverResponse>> getAllDrivers() {
	    return ResponseEntity.ok(driverService.getAllDrivers());
	}
}
