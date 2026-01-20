package com.ey.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ey.model.RouteStop;

@Repository
public interface RouteStopRepository extends JpaRepository<RouteStop, Integer> {

	List<RouteStop> findByRouteIdOrderBySequenceNumberAsc(int routeId);

	RouteStop findFirstByRouteIdAndSequenceNumber(int routeId, int sequenceNumber);

	Optional<RouteStop> findByStopId(Long stopId);

}
