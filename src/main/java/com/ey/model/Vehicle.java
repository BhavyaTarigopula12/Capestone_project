package com.ey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long vehicleId;
	private Long vehicleNumber;
	private String type;
	private Long seats;
	
	public Vehicle(Long vehicleId, Long vehicleNumber, String type, Long seats) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.seats = seats;
	}
	
	public Long getvehicleId() {
		return vehicleId;
	}
	public void setvehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Long getvehicleNumber() {
		return vehicleNumber;
	}
	public void setvehicleNumber(Long vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getSeats() {
		return seats;
	}
	public void setSeats(Long seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleNumber=" + vehicleNumber + ", type=" + type
				+ ", seats=" + seats + "]";
	}

}
