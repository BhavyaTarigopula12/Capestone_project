package com.ey.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class RatingRequest {
	@Min(1)
	@Max(5)
	private int stars;
	private String feedback;

	public RatingRequest() {
		super();
	}
	public RatingRequest(@Min(1) @Max(5) int stars, String feedback) {
		super();
		this.stars = stars;
		this.feedback = feedback;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "RatingRequest [stars=" + stars + ", feedback=" + feedback + "]";
	}

}
