package com.ey.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateDriverRequest {

	@NotBlank
	private String name;
	@NotBlank
	private String licenseNumber;
	@NotNull
	private LocalDate licenseValidTill;

	@NotBlank
	private String vehicleNumber;
	@NotBlank
	private String vehicleType;
	@Min(1)
	private int seats;
	@NotBlank
	private String phoneNumber;

	public CreateDriverRequest() {
		super();
	}

	public CreateDriverRequest(@NotBlank String name, @NotBlank String licenseNumber,
			@NotNull LocalDate licenseValidTill, @NotBlank String vehicleNumber, @NotBlank String vehicleType,
			@Min(1) int seats, @NotBlank String phoneNumber) {
		super();
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.licenseValidTill = licenseValidTill;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.seats = seats;
		this.phoneNumber = phoneNumber;
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
		return "CreateDriverRequest [name=" + name + ", licenseNumber=" + licenseNumber + ", licenseValidTill="
				+ licenseValidTill + ", vehicleNumber=" + vehicleNumber + ", vehicleType=" + vehicleType + ", seats="
				+ seats + ", phoneNumber=" + phoneNumber + "]";
	}
}
