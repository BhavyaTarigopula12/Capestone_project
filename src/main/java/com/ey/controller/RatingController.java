package com.ey.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ey.dto.request.RatingRequest;
import com.ey.dto.response.RatingResponse;
import com.ey.service.RatingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ratings")
@Validated
public class RatingController {
	private RatingService ratingService;

	public RatingController(RatingService ratingService) {
		this.ratingService = ratingService;
	}

	@PostMapping("/{tripId}/{userId}")
	public ResponseEntity<RatingResponse> createRating(@PathVariable Long tripId, @PathVariable Long userId,
			@Valid @RequestBody RatingRequest request) {
		RatingResponse resp = ratingService.createRating(tripId, userId, request);
		return ResponseEntity.status(201).body(resp);
	}

}
