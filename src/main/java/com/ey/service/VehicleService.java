package com.ey.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ey.model.Vehicle;
import com.ey.repository.VehicleRepository;

@Service
public class VehicleService {

    private static final Logger log = LoggerFactory.getLogger(VehicleService.class);

    private final VehicleRepository repo;

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
    }

    public Vehicle save(Vehicle v) {

        log.info("Saving vehicle number={}", v.getVehicleNumber());

        return repo.save(v);
    }

    public List<Vehicle> list() {

        log.info("Fetching all vehicles");

        return repo.findAll();
    }

    public Vehicle get(Long vehicleId) {
        return repo.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

}
