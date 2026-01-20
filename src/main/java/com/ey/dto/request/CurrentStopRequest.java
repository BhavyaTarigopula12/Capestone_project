package com.ey.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public class CurrentStopRequest {

	@NotNull
	private Long stopId;
	private LocalDateTime timestamp;

	public CurrentStopRequest() {
		super();
	}

	public CurrentStopRequest(@NotNull Long stopId, LocalDateTime timestamp) {
		super();
		this.stopId = stopId;
		this.timestamp = timestamp;
	}

	public Long getStopId() {
		return stopId;
	}

	public void setStopId(Long stopId) {
		this.stopId = stopId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "CurrentStopRequest [ stopId=" + stopId + ", timestamp=" + timestamp + "]";
	}

}
