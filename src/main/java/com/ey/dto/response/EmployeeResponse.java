package com.ey.dto.response;

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

public class EmployeeResponse {@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	private String name;

	@Column(unique = true, nullable = false)
	private String email;


	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	private String phone;


	public EmployeeResponse(Long employeeId, String name, String email,Role role, String phone) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.role = role;
		this.phone = phone;
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


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", email=" + email + ",  role=" + role + ", phone=" + phone + "]";
	}

}
