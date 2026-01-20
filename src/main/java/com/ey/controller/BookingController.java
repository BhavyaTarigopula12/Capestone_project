package com.ey.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.dto.request.BookingRequest;
import com.ey.dto.response.BookingResponse;
import com.ey.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bookings")
@Validated
public class BookingController {
	private BookingService bookingService;
	public BookingController(BookingService bookingService) {
		this.bookingService=bookingService;
	}
	@PostMapping("/{userId}")
	public ResponseEntity<BookingResponse>createBooking(@PathVariable Long userId,@Valid @RequestBody BookingRequest request){
		BookingResponse resp=bookingService.createBooking(request,userId);
		return ResponseEntity.status(201).body(resp);
	}
	@GetMapping("/{bookingId}")
	public ResponseEntity<BookingResponse>getBooking(@PathVariable Long bookingId){
		return ResponseEntity.ok(bookingService.getBooking(bookingId));
	}
	@GetMapping("/{userId}")
	public ResponseEntity<?> getBookings(@PathVariable Long userId) {
	    return ResponseEntity.ok(bookingService.getBooking(userId));
	}


}
