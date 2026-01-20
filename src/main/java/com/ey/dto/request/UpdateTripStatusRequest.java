package com.ey.dto.request;

import jakarta.validation.constraints.NotBlank;

public class UpdateTripStatusRequest {
	@NotBlank
	private String tripStatus;

	public UpdateTripStatusRequest() {
		super();
	}

	public UpdateTripStatusRequest(@NotBlank String tripStatus) {
		super();
		this.tripStatus = tripStatus;
	}

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	@Override
	public String toString() {
		return "UpdateTripStatusRequest [tripStatus=" + tripStatus + "]";
	}
}
