package com.ey.dto.response;

public class StopsResponse {
	private Long stopId;
	private int created;

	public StopsResponse(int created, Long stopId) {
		super();
		this.created = created;
		this.stopId = stopId;
	}

	public int getCreated() {
		return created;
	}

	public void setCreated(int created) {
		this.created = created;
	}

	public Long getStopId() {
		return stopId;
	}

	public void setStopId(Long stopId) {
		this.stopId = stopId;
	}

	@Override
	public String toString() {
		return "StopsResponse [stopId=" + stopId + ",created=" + created + "]";
	}


}
