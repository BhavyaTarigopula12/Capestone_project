package com.ey.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Driver {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long driverId;
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
    
	public Driver() {
		super();
	}
	public Driver(Long driverId, @NotBlank String name, @NotBlank String licenseNumber,
			@NotNull LocalDate licenseValidTill, @NotBlank String vehicleNumber, @NotBlank String vehicleType,
			@Min(1) int seats, @NotBlank String phoneNumber) {
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
		return "Driver [driverId=" + driverId + ", name=" + name + ", licenseNumber=" + licenseNumber
				+ ", licenseValidTill=" + licenseValidTill + ", vehicleNumber=" + vehicleNumber + ", vehicleType="
				+ vehicleType + ", seats=" + seats + ", phoneNumber=" + phoneNumber + "]";
	}

}