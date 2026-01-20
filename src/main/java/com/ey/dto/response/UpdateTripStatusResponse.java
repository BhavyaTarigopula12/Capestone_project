package com.ey.dto.response;

import java.time.LocalDateTime;

public class UpdateTripStatusResponse {
	private Long tripId;
	private String tripStatus;
	private LocalDateTime updatedAt;

	public UpdateTripStatusResponse(Long tripId, String tripStatus, LocalDateTime updatedAt) {
		super();
		this.tripId = tripId;
		this.tripStatus = tripStatus;
		this.updatedAt = updatedAt;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "UpdateTripStatusResponse [tripId=" + tripId + ", tripStatus=" + tripStatus + ", updatedAt=" + updatedAt
				+ "]";
	}
}
