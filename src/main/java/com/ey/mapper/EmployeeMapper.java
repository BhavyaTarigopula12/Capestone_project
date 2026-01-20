package com.ey.mapper;

import com.ey.dto.response.EmployeeResponse;
import com.ey.model.Employee;

public class EmployeeMapper {
	public static EmployeeResponse toResponse(Employee employee) {
		return new EmployeeResponse(
				employee.getEmployeeId(),
				employee.getName(),
				employee.getEmail(),
				employee.getRole(),
				employee.getPhone()
				);
	}

}
