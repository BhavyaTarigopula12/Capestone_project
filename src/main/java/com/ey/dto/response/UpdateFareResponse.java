package com.ey.dto.response;

import java.time.LocalDateTime;

public class UpdateFareResponse {
	private Long routeId;
	private double farePricePerKm;
	private LocalDateTime updatedAt;

	public UpdateFareResponse(Long routeId, double farePricePerKm, LocalDateTime updatedAt) {
		super();
		this.routeId = routeId;
		this.farePricePerKm = farePricePerKm;
		this.updatedAt = updatedAt;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public double getFarePricePerKm() {
		return farePricePerKm;
	}

	public void setFarePricePerKm(double farePricePerKm) {
		this.farePricePerKm = farePricePerKm;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "UpdateFareResponse [routeId=" + routeId + ", farePricePerKm=" + farePricePerKm + ", updatedAt="
				+ updatedAt + "]";
	}
}
