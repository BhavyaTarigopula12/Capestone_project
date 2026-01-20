package com.ey.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ey.enums.Role;
import com.ey.enums.SubscriptionType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EmployeeRequest {@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	private String name;

	@Column(unique = true, nullable = false)
	private String email;

	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	private String phone;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private SubscriptionType subscriptionType;
	@Column(nullable = false)
	private LocalDate subscriptionValidFrom;
	@Column(nullable = false)
	private LocalDate subscriptionValidTill;

	public EmployeeRequest() {
	    this.subscriptionType = SubscriptionType.NONE;
	    this.subscriptionValidFrom = LocalDate.now();
	    this.subscriptionValidTill = LocalDate.now();
	}

	public EmployeeRequest(Long employeeId, String name, String email, String password, Role role, String phone,
			SubscriptionType subscriptionType, LocalDate subscriptionValidFrom, LocalDate subscriptionValidTill) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.phone = phone;
		this.subscriptionType = subscriptionType;
		this.subscriptionValidFrom = subscriptionValidFrom;
		this.subscriptionValidTill = subscriptionValidTill;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public SubscriptionType getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(SubscriptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public LocalDate getSubscriptionValidFrom() {
		return subscriptionValidFrom;
	}

	public void setSubscriptionValidFrom(LocalDate subscriptionValidFrom) {
		this.subscriptionValidFrom = subscriptionValidFrom;
	}

	public LocalDate getSubscriptionValidTill() {
		return subscriptionValidTill;
	}

	public void setSubscriptionValidTill(LocalDate subscriptionValidTill) {
		this.subscriptionValidTill = subscriptionValidTill;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", phone=" + phone + ", subscriptionType=" + subscriptionType
				+ ", subscriptionValidFrom=" + subscriptionValidFrom + ", subscriptionValidTill="
				+ subscriptionValidTill + "]";
	}

}
