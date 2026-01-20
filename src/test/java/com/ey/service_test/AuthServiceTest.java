package com.ey.service_test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ey.dto.request.LoginRequest;
import com.ey.dto.request.RegisterRequest;
import com.ey.dto.response.LoginResponse;
import com.ey.enums.Role;
import com.ey.model.Employee;
import com.ey.repository.EmployeeRepository;
import com.ey.service.AuthService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Employee testEmployee;

    @BeforeEach
    void setup() {
        testEmployee = employeeRepository.findByEmail("testuser@gmail.com").orElse(null);

        if (testEmployee == null) {
            testEmployee = new Employee();
            testEmployee.setName("Test User");
            testEmployee.setEmail("testuser@gmail.com");
            testEmployee.setPassword(passwordEncoder.encode("1234"));
            testEmployee.setRole(Role.EMPLOYEE);
            testEmployee.setPhone("9876543210");
            testEmployee = employeeRepository.save(testEmployee);
        } else {
            testEmployee.setPassword(passwordEncoder.encode("1234"));
            employeeRepository.save(testEmployee);
        }
    }

    @Test
    void testRegisterSuccess() {
        RegisterRequest request = new RegisterRequest();
        request.setName("New User");
        request.setEmail("newuser@gmail.com");
        request.setPassword("abcd");
        request.setRole(Role.EMPLOYEE);
        request.setPhone("9999999999");

        Employee saved = authService.register(request);

        assertThat(saved.getEmployeeId()).isNotNull();
        assertThat(saved.getEmail()).isEqualTo("newuser@gmail.com");
    }

    @Test
    void testLoginSuccess() {
        LoginRequest request = new LoginRequest();
        request.setEmail("testuser@gmail.com");
        request.setPassword("1234");

        LoginResponse response = authService.login(request);

        assertThat(response.getAccessToken()).isNotNull();
        assertThat(response.getUser().getEmail()).isEqualTo("testuser@gmail.com");
    }

    @Test
    void testForgotPasswordSuccess() {
        String response = authService.forgotPassword(
                "testuser@gmail.com",
                "newPassword123"
        );

        assertEquals("Password changed successfully", response);

        Employee updated = employeeRepository.findByEmail("testuser@gmail.com").get();
        assertThat(passwordEncoder.matches("newPassword123", updated.getPassword())).isTrue();
    }

    @Test
    void testResetPasswordWrongOldPassword() {
        try {
            authService.resetPassword(
                    "testuser@gmail.com",
                    "wrongPassword",
                    "newPassword123"
            );
        } catch (RuntimeException ex) {
            assertEquals("Old password incorrect", ex.getMessage());
        }
    }
}
