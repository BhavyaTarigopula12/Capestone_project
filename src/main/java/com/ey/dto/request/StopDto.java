package com.ey.dto.request;

import java.time.LocalTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StopDto {
	private Long stopId;
	private Long routeId;
	@NotBlank
	private String stopName;
	@Min(1)
	private int sequenceNumber;
	@NotNull
	private LocalTime pickupTime;
	private double distanceFromStart;
	
	public StopDto() {
		super();
	}

	public StopDto(Long stopId, Long routeId, @NotBlank String stopName, @Min(1) int sequenceNumber,
			@NotNull LocalTime pickupTime, double distanceFromStart) {
		super();
		this.stopId = stopId;
		this.routeId = routeId;
		this.stopName = stopName;
		this.sequenceNumber = sequenceNumber;
		this.pickupTime = pickupTime;
		this.distanceFromStart = distanceFromStart;
	}

	public Long getStopId() {
		return stopId;
	}

	public void setStopId(Long stopId) {
		this.stopId = stopId;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public LocalTime getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(LocalTime pickupTime) {
		this.pickupTime = pickupTime;
	}

	public double getDistanceFromStart() {
		return distanceFromStart;
	}

	public void setDistanceFromStart(double distanceFromStart) {
		this.distanceFromStart = distanceFromStart;
	}

	@Override
	public String toString() {
		return "StopDto [stopId=" + stopId + ",routeId=" + routeId + ",stopName=" + stopName + ", sequenceNumber="
				+ sequenceNumber + ", pickupTime=" + pickupTime + ", distanceFromStart=" + distanceFromStart + "]";
	}

}
