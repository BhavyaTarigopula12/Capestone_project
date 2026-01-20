package com.ey.dto.request;

import jakarta.validation.constraints.Positive;

public class UpdateFareRequest {

	@Positive
	private double farePricePerKm;
	public UpdateFareRequest() {
		super();
	}
	public UpdateFareRequest(@Positive double farePricePerKm) {
		super();
		this.farePricePerKm = farePricePerKm;
	}

	public double getFarePricePerKm() {
		return farePricePerKm;
	}

	public void setFarePricePerKm(double farePricePerKm) {
		this.farePricePerKm = farePricePerKm;
	}

	@Override
	public String toString() {
		return "UpdateFareRequest [farePricePerKm=" + farePricePerKm + "]";
	}
}
