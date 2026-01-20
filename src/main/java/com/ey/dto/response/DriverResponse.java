package com.ey.dto.response;

import java.time.LocalDate;

public class DriverResponse {
	private Long driverId;
	private String name;
	private String licenseNumber;
	private LocalDate licenseValidTill;
	private String vehicleNumber;
	private String vehicleType;
	private int seats;
	private String phoneNumber;

	public DriverResponse(Long driverId, String name, String licenseNumber, LocalDate licenseValidTill,
			String vehicleNumber, String vehicleType, int seats, String phoneNumber) {
		super();
		this.driverId = driverId;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.licenseValidTill = licenseValidTill;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.seats = seats;
		this.phoneNumber = phoneNumber;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public LocalDate getLicenseValidTill() {
		return licenseValidTill;
	}

	public void setLicenseValidTill(LocalDate licenseValidTill) {
		this.licenseValidTill = licenseValidTill;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "DriverResponse [driverId=" + driverId + ", name=" + name + ", licenseNumber=" + licenseNumber
				+ ", licenseValidTill=" + licenseValidTill + ", vehicleNumber=" + vehicleNumber + ", vehicleType="
				+ vehicleType + ", seats=" + seats + ", phoneNumber=" + phoneNumber + "]";
	}

}
