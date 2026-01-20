package com.ey.mapper;

import com.ey.dto.request.CreateDriverRequest;
import com.ey.dto.response.DriverResponse;
import com.ey.model.Driver;

public class DriverMapper {
	public static Driver toEntity(CreateDriverRequest req) {
		return new Driver(
				null,
				req.getName(),
				req.getLicenseNumber(),
				req.getLicenseValidTill(),
				req.getVehicleNumber(),
				req.getVehicleType(),
				req.getSeats(),
				req.getPhoneNumber()
				);
	}
	public static DriverResponse toResponse(Driver driver) {
		return new DriverResponse(
				driver.getDriverId(),
				driver.getName(),
				driver.getLicenseNumber(),
				driver.getLicenseValidTill(),
				driver.getVehicleNumber(),
				driver.getVehicleType(),
				driver.getSeats(),
				driver.getPhoneNumber()
				);
	}

}
