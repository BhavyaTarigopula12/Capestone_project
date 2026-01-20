package com.ey.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateTripRequest {
	@NotNull
	private Long routeId;
	@NotNull
	private LocalDate tripDate;
	@NotNull
	private LocalTime startTime;
	@NotBlank
	private String vehicleNumber;
	@NotNull
	private Long driverId;
	
	public CreateTripRequest() {
		super();
	}

	public CreateTripRequest(@NotNull Long routeId, @NotNull LocalDate tripDate, @NotNull LocalTime startTime,
			@NotBlank String vehicleNumber, @NotNull Long driverId) {
		super();
		this.routeId = routeId;
		this.tripDate = tripDate;
		this.startTime = startTime;
		this.vehicleNumber = vehicleNumber;
		this.driverId = driverId;
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

	@Override
	public String toString() {
		return "CreateTripRequest [routeId=" + routeId + ", tripDate=" + tripDate + ", startTime=" + startTime
				+ ", vehicleNumber=" + vehicleNumber + ", driverId=" + driverId + "]";
	}

}
