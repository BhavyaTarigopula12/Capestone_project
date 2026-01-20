package com.ey.dto.response;

import java.time.LocalDateTime;

public class BookingResponse {
	private Long bookingId;
	private String status;
	private double fare;
	private LocalDateTime pickupTime;
	private TripSummary trip;

	public BookingResponse(Long bookingId, String status, double fare, LocalDateTime pickupTime, TripSummary trip) {
		super();
		this.bookingId = bookingId;
		this.status = status;
		this.fare = fare;
		this.pickupTime = pickupTime;
		this.trip = trip;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public LocalDateTime getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(LocalDateTime pickupTime) {
		this.pickupTime = pickupTime;
	}

	public TripSummary getTrip() {
		return trip;
	}

	public void setTrip(TripSummary trip) {
		this.trip = trip;
	}
}
