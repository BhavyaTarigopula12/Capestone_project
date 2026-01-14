package com.ey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookingId;
	private Long tripId;
	private Long userId;
	private Long from;
	private Long to;
	private double fare;
	private String status;
	
	public Booking(Long bookingId, Long tripId, Long userId, Long from, Long to, double fare,
			String status) {
		super();
		this.bookingId = bookingId;
		this.tripId = tripId;
		this.userId = userId;
		this.from = from;
		this.to = to;
		this.fare = fare;
		this.status = status;
	}
	
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
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
	public Long getfrom() {
		return from;
	}
	public void setfrom(Long from) {
		this.from = from;
	}
	public Long getto() {
		return to;
	}
	public void setto(Long to) {
		this.to = to;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", tripId=" + tripId + ", userId=" + userId + ", from="
				+ from + ", to=" + to + ", fare=" + fare + ", status=" + status + "]";
	}
}
