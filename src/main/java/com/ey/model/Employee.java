package com.ey.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int employeeId;
	private int employeeCode;
	private String subscriptionType;
	private LocalDate subscriptionValidFrom;
	private LocalDate subscriptionValidTill;
	
	public Employee(int employeeId, int employeeCode, String subscriptionType, LocalDate subscriptionValidFrom,
			LocalDate subscriptionValidTill) {
		super();
		this.employeeId = employeeId;
		this.employeeCode = employeeCode;
		this.subscriptionType = subscriptionType;
		this.subscriptionValidFrom = subscriptionValidFrom;
		this.subscriptionValidTill = subscriptionValidTill;
	}
	
	public int getemployeeId() {
		return employeeId;
	}
	public void setemployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getemployeeCode() {
		return employeeCode;
	}
	public void setemployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getsubscriptionType() {
		return subscriptionType;
	}
	public void setsubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	public LocalDate getsubscriptionValidFrom() {
		return subscriptionValidFrom;
	}
	public void setsubscriptionValidFrom(LocalDate subscriptionValidFrom) {
		this.subscriptionValidFrom = subscriptionValidFrom;
	}
	public LocalDate getsubscriptionValidTill() {
		return subscriptionValidTill;
	}
	public void setsubscriptionValidTill(LocalDate subscriptionValidTill) {
		this.subscriptionValidTill = subscriptionValidTill;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeCode=" + employeeCode + ", subscriptionType="
				+ subscriptionType + ", subscriptionValidFrom=" + subscriptionValidFrom
				+ ", subscriptionValidTill=" + subscriptionValidTill + "]";
	}

}
