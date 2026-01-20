package com.ey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	private Long tripId;
	private Long userId;
	private Long pickupStopId;
	private Long dropStopId;
	private double fare;
	private String status;

	public Booking() {
		super();
	}

	public Booking(Long bookingId, Long tripId, Long userId, Long pickupStopId, Long dropStopId, double fare,
			String status) {
		super();
		this.bookingId = bookingId;
		this.tripId = tripId;
		this.userId = userId;
		this.pickupStopId = pickupStopId;
		this.dropStopId = dropStopId;
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

	public Long getPickupStopId() {
		return pickupStopId;
	}

	public void setPickupStopId(Long pickupStopId) {
		this.pickupStopId = pickupStopId;
	}

	public Long getDropStopId() {
		return dropStopId;
	}

	public void setDropStopId(Long dropStopId) {
		this.dropStopId = dropStopId;
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
		return "Booking [bookingId=" + bookingId + ", tripId=" + tripId + ", userId=" + userId + ", pickupStopId="
				+ pickupStopId + ", dropStopId=" + dropStopId + ", fare=" + fare + ", status=" + status + "]";
	}

}
