package com.ey.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ey.dto.request.CreateDriverRequest;
import com.ey.dto.response.DriverResponse;
import com.ey.mapper.DriverMapper;
import com.ey.model.Driver;
import com.ey.repository.DriverRepository;

@Service
public class DriverService {

    private static final Logger log = LoggerFactory.getLogger(DriverService.class);

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public DriverResponse createDriver(CreateDriverRequest request) {

        log.info("Creating driver with license={}", request.getLicenseNumber());

        Driver driver = DriverMapper.toEntity(request);
        driver = driverRepository.save(driver);

        log.info("Driver created with driverId={}", driver.getDriverId());

        return DriverMapper.toResponse(driver);
    }

    public DriverResponse getDriver(Long driverId) {

        log.info("Fetching driver with driverId={}", driverId);

        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new IllegalArgumentException("Driver not found"));

        return DriverMapper.toResponse(driver);
    }

	    public List<DriverResponse> getAllDrivers() {
        return driverRepository.findAll()
                .stream()
                .map(DriverMapper::toResponse)
                .toList();
    }

}
