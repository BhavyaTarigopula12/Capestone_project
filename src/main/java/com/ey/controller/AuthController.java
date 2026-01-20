package com.ey.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.dto.request.ForgotPasswordRequest;
import com.ey.dto.request.LoginRequest;
import com.ey.dto.request.RegisterRequest;
import com.ey.dto.request.ResetPasswordRequest;
import com.ey.dto.response.LoginResponse;
import com.ey.model.Employee;
import com.ey.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {

    private static final Logger log =
            LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        log.info("Login request received for email: {}", request.getEmail());
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<Employee> register(@RequestBody RegisterRequest request) {
        log.info("Register request received for email: {}", request.getEmail());
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgot(@RequestBody ForgotPasswordRequest request) {
        log.warn("Forgot password request for email: {}", request.getEmail());
        return ResponseEntity.ok(
                authService.forgotPassword(
                        request.getEmail(),
                        request.getNewPassword()
                )
        );
    }
    @PostMapping("/reset-password")
    public ResponseEntity<String> reset(@RequestBody ResetPasswordRequest request) {
        log.warn("Reset password request for email: {}", request.getEmail());
        return ResponseEntity.ok(
                authService.resetPassword(
                        request.getEmail(),
                        request.getOldPassword(),
                        request.getNewPassword()
                )
        );
    }
}
