package com.ey.mapper;

import com.ey.dto.request.RatingRequest;
import com.ey.dto.response.RatingResponse;
import com.ey.model.Rating;

public class RatingMapper {
	public static Rating toEntity(RatingRequest req, Long tripId, Long userId) {
		return new Rating(
				null,
				tripId,
				userId,
				req.getStars(),
				req.getFeedback()
				);
	}
	public static RatingResponse toResponse(Rating rating) {
		return new RatingResponse(
				rating.getRatingId(),
				rating.getTripId(),
				rating.getUserId(),
				rating.getStars(),
				rating.getFeedback()
				);
	}

}
