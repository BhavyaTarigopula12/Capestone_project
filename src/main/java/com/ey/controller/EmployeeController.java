package com.ey.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ey.dto.response.DriverResponse;
import com.ey.enums.SubscriptionType;
import com.ey.model.Employee;
import com.ey.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	@GetMapping
	public ResponseEntity<Object> getAllEmployees() {
	    return ResponseEntity.ok(service.getAllEmployees());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		return ResponseEntity.ok(service.getMyProfile(id));
	}
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
	    return service.saveEmployee(employee);
	}
	@PutMapping("/{id}/subscribe")
	public Employee subscribe(
	        @PathVariable Long id,@RequestParam SubscriptionType subscriptionType) {
	    return service.subscribe(id, subscriptionType);
	}
}
