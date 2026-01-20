package com.ey.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ey.dto.response.EmployeeResponse;
import com.ey.enums.SubscriptionType;
import com.ey.mapper.EmployeeMapper;
import com.ey.model.Employee;
import com.ey.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee getMyProfile(Long employeeId) {

        log.info("Fetching profile for employeeId={}", employeeId);

        return employeeRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
    public Employee saveEmployee(Employee employee) {

        log.info("Registering new employee");

        employee.setSubscriptionType(SubscriptionType.NONE);
        employee.setSubscriptionValidFrom(LocalDate.now());
        employee.setSubscriptionValidTill(LocalDate.now());

        return employeeRepo.save(employee);
    }

    public Employee subscribe(Long employeeId, SubscriptionType type) {

        log.info("Employee {} taking subscription {}", employeeId, type);

        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setSubscriptionType(type);
        employee.setSubscriptionValidFrom(LocalDate.now());

        if (type == SubscriptionType.WEEKLY) {
            employee.setSubscriptionValidTill(LocalDate.now().plusWeeks(1));
        }
        else if (type == SubscriptionType.MONTHLY) {
            employee.setSubscriptionValidTill(LocalDate.now().plusMonths(1));
        }
        else {
            employee.setSubscriptionValidTill(LocalDate.now());
        }

        return employeeRepo.save(employee);
    }

    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepo.findAll()
                .stream()
                .map(EmployeeMapper::toResponse)
                .toList();
    }

}
