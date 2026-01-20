package com.ey.dto.response;

import java.time.LocalDate;

public class TripSummary {
	private Long tripId;
	private Long routeId;
	private LocalDate tripDate;
	private String tripstatus;

	public TripSummary(Long tripId, Long routeId, LocalDate tripDate, String tripstatus) {
		super();
		this.tripId = tripId;
		this.routeId = routeId;
		this.tripDate = tripDate;
		this.tripstatus =tripstatus;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	public String getTripStatus() {
		return tripstatus;
	}

	public void setTripStatus(String tripstatus) {
		this.tripstatus = tripstatus;
	}


}
