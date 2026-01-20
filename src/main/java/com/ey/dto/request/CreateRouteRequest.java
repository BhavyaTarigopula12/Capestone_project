package com.ey.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CreateRouteRequest {

	@NotBlank
	private String fromLocation;
	@NotBlank
	private String toLocation;
	@Positive
	private double distance;
	@Positive
	private double farePricePerKm;

	public CreateRouteRequest() {
		super();
	}

	public CreateRouteRequest(@NotBlank String fromLocation, @NotBlank String toLocation, @Positive double distance,
			@Positive double farePricePerKm) {
		super();
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.distance = distance;
		this.farePricePerKm = farePricePerKm;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getFarePricePerKm() {
		return farePricePerKm;
	}

	public void setFarePricePerKm(double farePricePerKm) {
		this.farePricePerKm = farePricePerKm;
	}

	@Override
	public String toString() {
		return "CreateRouteRequest [fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", distance="
				+ distance + ", farePricePerKm=" + farePricePerKm + "]";
	}

}
