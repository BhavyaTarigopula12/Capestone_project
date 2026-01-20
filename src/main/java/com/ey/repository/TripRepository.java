package com.ey.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ey.model.Trip;
import com.ey.model.Vehicle;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

	List<Trip> findByRouteId(Long routeId);

	List<Trip> findByTripDate(LocalDate tripDate);

	List<Trip> findByTripStatus(String status);

}
