package com.ey.service_test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ey.model.Vehicle;
import com.ey.service.VehicleService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class VehicleServiceTest {

    @Autowired
    private VehicleService vehicleService;

    @Test
    void testSaveVehicleSuccess() {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber("TN38AB1234");
        vehicle.setVehicleType("BUS");
        vehicle.setSeats(40);

        Vehicle saved = vehicleService.save(vehicle);

        assertThat(saved.getVehicleId()).isNotNull();
    }

    @Test
    void testListVehicles() {

        Vehicle v1 = new Vehicle();
        v1.setVehicleNumber("TN38AB1111");
        v1.setVehicleType("BUS");
        v1.setSeats(30);

        vehicleService.save(v1);

        List<Vehicle> vehicles = vehicleService.list();

        assertThat(vehicles.size()).isGreaterThan(0);
    }
}
