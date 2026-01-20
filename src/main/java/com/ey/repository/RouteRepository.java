package com.ey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ey.model.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

	boolean existsByFromLocationAndToLocation(String fromLocation, String toLocation);
}
