package com.ey.dto.response;

public class CurrentStopResponse {
	private boolean accepted;

	public CurrentStopResponse(boolean accepted) {
		super();
		this.accepted = accepted;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	@Override
	public String toString() {
		return "CurrentStopResponse [accepted=" + accepted + "]";
	}
}
