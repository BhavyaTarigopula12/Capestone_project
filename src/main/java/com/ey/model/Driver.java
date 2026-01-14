package com.ey.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Driver {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int driverId;
	private String licenseNumber;
	LocalDate licenseValidTill;
	private int phoneNumber;
	private double avgRating;
	
	public Driver(int driverId, String licenseNumber, LocalDate licenseValidTill, int phoneNumber,
			double avgRating) {
		super();
		this.driverId = driverId;
		this.licenseNumber = licenseNumber;
		this.licenseValidTill = licenseValidTill;
		this.phoneNumber = phoneNumber;
		this.avgRating = avgRating;
	}
	
	public int getdriverId() {
		return driverId;
	}
	public void setdriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getlicenseNumber() {
		return licenseNumber;
	}
	public void setlicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public LocalDate getlicenseValidTill() {
		return licenseValidTill;
	}
	public void setlicenseValidTill(LocalDate licenseValidTill) {
		this.licenseValidTill = licenseValidTill;
	}
	public int getphoneNumber() {
		return phoneNumber;
	}
	public void setphoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getavgRating() {
		return avgRating;
	}
	public void setavgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenseNumber=" + licenseNumber + ", licenseValidTill="
				+ licenseValidTill + ", phoneNumber=" + phoneNumber + ", avgRating=" + avgRating + "]";
	}
}
