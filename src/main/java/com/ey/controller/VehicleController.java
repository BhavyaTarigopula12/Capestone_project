package com.ey.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.model.Vehicle;
import com.ey.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

	private final VehicleService service;

	public VehicleController(VehicleService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Vehicle> create(@RequestBody Vehicle v) {
		return ResponseEntity.status(201).body(service.save(v));
	}

	@GetMapping
	public List<Vehicle> list() {
		return service.list();
	}
	@GetMapping("/{vehicleId}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable Long vehicleId) {
	    return ResponseEntity.ok(service.get(vehicleId));
	}

}
