package com.ey.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ey.dto.request.LoginRequest;
import com.ey.dto.request.RegisterRequest;
import com.ey.dto.response.LoginResponse;
import com.ey.dto.response.UserInfo;
import com.ey.mapper.AuthMapper;
import com.ey.model.Employee;
import com.ey.repository.EmployeeRepository;
import com.ey.security.JwtUtil;

@Service
public class AuthService {

    private static final Logger log =
            LoggerFactory.getLogger(AuthService.class);

    private final EmployeeRepository employeeRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(EmployeeRepository employeeRepo,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {
        this.employeeRepo = employeeRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public Employee register(RegisterRequest request) {
        log.info("Registering user {}", request.getEmail());

        System.out.print("..............................................");
        if (employeeRepo.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        Employee emp = new Employee();
        emp.setName(request.getName());
        emp.setEmail(request.getEmail());
        emp.setPassword(passwordEncoder.encode(request.getPassword()));
        emp.setRole(request.getRole());
        emp.setPhone(request.getPhone());

        return employeeRepo.save(emp);
    }

    public LoginResponse login(LoginRequest request) {
        log.info("Login attempt for {}", request.getEmail());

        Employee emp = employeeRepo.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid username or password")
                );

        if (!passwordEncoder.matches(request.getPassword(), emp.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = jwtUtil.generateToken(request.getEmail(),emp.getRole());
        UserInfo user = new UserInfo(
                emp.getEmployeeId(),
                emp.getName(),
                emp.getRole().name(),
                emp.getEmail()
        );

        return AuthMapper.toResponse(token, user, 3600L);
    }

    public String forgotPassword(String email, String newPassword) {
        log.warn("Forgot password for {}", email);

        Employee emp = employeeRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email not found"));

        emp.setPassword(passwordEncoder.encode(newPassword));
        employeeRepo.save(emp);

        return "Password changed successfully";
    }

    public String resetPassword(String email,
                                String oldPassword,
                                String newPassword) {

        Employee emp = employeeRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(oldPassword, emp.getPassword())) {
            throw new RuntimeException("Old password incorrect");
        }

        emp.setPassword(passwordEncoder.encode(newPassword));
        employeeRepo.save(emp);

        return "Password reset successful";
    }
}
