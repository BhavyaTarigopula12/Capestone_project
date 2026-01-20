package com.ey.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ey.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

	Optional<Driver> findByLicenseNumber(String licenseNumber);

	boolean existsByVehicleNumber(String vehicleNumber);
}
