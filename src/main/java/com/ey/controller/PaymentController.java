package com.ey.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.model.Payment;
import com.ey.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	private final PaymentService service;

	public PaymentController(PaymentService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Payment> create(@RequestBody Payment p) {
		return ResponseEntity.status(201).body(service.create(p));
	}
	@GetMapping
	public ResponseEntity<List<Payment>> getAllPayments() {
	    return ResponseEntity.ok(service.getAll());
	}
}
