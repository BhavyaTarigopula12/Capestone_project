package com.ey.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ey.model.Payment;
import com.ey.repository.PaymentRepository;

@Service
public class PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    private final PaymentRepository repo;

    public PaymentService(PaymentRepository repo) {
        this.repo = repo;
    }

    public Payment create(Payment p) {

        log.info("Creating payment for bookingId={}", p.getBookingId());

        Payment payment = repo.save(p);

        log.info("Payment created with paymentId={}", payment.getPaymentId());

        return payment;
    }

	public List<Payment> getAll() {
        return repo.findAll();
    }
}
