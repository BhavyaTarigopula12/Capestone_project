package com.ey.dto.request;

import jakarta.validation.constraints.NotNull;

public class BookingRequest {
	@NotNull
	private Long tripId;
	@NotNull
	private Long pickupStopId;
	@NotNull
	private Long dropStopId;

	public BookingRequest() {
		super();
	}

	public BookingRequest(@NotNull Long tripId, @NotNull Long pickupStopId, @NotNull Long dropStopId) {
		super();
		this.tripId = tripId;
		this.pickupStopId = pickupStopId;
		this.dropStopId = dropStopId;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public Long getPickupStopId() {
		return pickupStopId;
	}

	public void setPickupStopId(Long pickupStopId) {
		this.pickupStopId = pickupStopId;
	}

	public Long getDropStopId() {
		return dropStopId;
	}

	public void setDropStopId(Long dropStopId) {
		this.dropStopId = dropStopId;
	}

	@Override
	public String toString() {
		return "BookingRequest [tripId=" + tripId + ", pickupStopId=" + pickupStopId + ", dropStopId=" + dropStopId
				+ "]";
	}

}
