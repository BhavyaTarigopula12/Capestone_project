package com.ey.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class AddStopsRequest {
	@NotEmpty
	private List<StopDto> stops;

	public AddStopsRequest() {
		super();
	}

	public List<StopDto> getStops() {
		return stops;
	}

	public void setStops(List<StopDto> stops) {
		this.stops = stops;
	}

	@Override
	public String toString() {
		return "AddStopsRequest [stops=" + stops + "]";
	}

	public AddStopsRequest(@NotEmpty List<StopDto> stops) {
		super();
		this.stops = stops;
	}

}
