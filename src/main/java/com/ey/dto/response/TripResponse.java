package com.ey.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

public class TripResponse {
	private Long tripId;
	private Long routeId;
	private LocalDate tripDate;
	private LocalTime startTime;
	private String vehicleNumber;
	private Long driverId;
	private String tripStatus;

	public TripResponse(Long tripId, Long routeId, LocalDate tripDate, LocalTime startTime, String vehicleNumber,
			Long driverId, String tripStatus) {
		super();
		this.tripId = tripId;
		this.routeId = routeId;
		this.tripDate = tripDate;
		this.startTime = startTime;
		this.vehicleNumber = vehicleNumber;
		this.driverId = driverId;
		this.tripStatus = tripStatus;
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

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	@Override
	public String toString() {
		return "TripResponse [tripId=" + tripId + ", routeId=" + routeId + ", tripDate=" + tripDate + ", startTime="
				+ startTime + ", vehicleNumber=" + vehicleNumber + ", driverId=" + driverId + ", tripStatus="
				+ tripStatus + "]";
	}

}
