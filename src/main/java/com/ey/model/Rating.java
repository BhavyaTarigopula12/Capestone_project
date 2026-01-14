package com.ey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ratingId;
	private Long tripId;
	private Long userId;
	private Long stars;
	private String feedback;
	
	public Rating(Long ratingId, Long tripId, Long userId, Long stars, String feedback) {
		super();
		this.ratingId = ratingId;
		this.tripId = tripId;
		this.userId = userId;
		this.stars = stars;
		this.feedback = feedback;
	}
	
	public Long getRatingId() {
		return ratingId;
	}
	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}
	public Long getTripId() {
		return tripId;
	}
	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getStars() {
		return stars;
	}
	public void setStars(Long stars) {
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
		return "Rating [ratingId=" + ratingId + ", tripId=" + tripId + ", userId=" + userId + ", stars=" + stars
				+ ", feedback=" + feedback + "]";
	}

}
