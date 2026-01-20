package com.ey.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tripId;
	private Long routeId;
	private LocalDate tripDate;
	private LocalTime startTime;
	private Long totalSeats;
	private Long bookedSeats;
	private String tripStatus;
	
	@OneToOne
	@JoinColumn(name="driver_id")
	private Driver driver;

	
	
	public Trip() {
		super();
	}

	public Trip(Long tripId, Long routeId, LocalDate tripDate, LocalTime startTime, Long totalSeats, Long bookedSeats,
			String tripStatus,Driver driver) {
		super();
		this.tripId = tripId;
		this.routeId = routeId;
		this.tripDate = tripDate;
		this.startTime = startTime;
		this.totalSeats = totalSeats;
		this.bookedSeats = bookedSeats;
		this.tripStatus = tripStatus;
		this.driver=driver;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public Long getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Long totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Long getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(Long bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	@Override
	public String toString() {
		return "Trip [tripId=" + tripId + ", routeId=" + routeId + ", tripDate=" + tripDate + ", startTime=" + startTime
				+ ", totalSeats=" + totalSeats + ", bookedSeats=" + bookedSeats + ", tripStatus=" + tripStatus + "]";
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}
