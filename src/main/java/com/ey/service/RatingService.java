package com.ey.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ey.dto.request.RatingRequest;
import com.ey.dto.response.RatingResponse;
import com.ey.mapper.RatingMapper;
import com.ey.model.Rating;
import com.ey.repository.RatingRepository;

@Service
public class RatingService {

    private static final Logger log = LoggerFactory.getLogger(RatingService.class);

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public RatingResponse createRating(Long tripId, Long userId, RatingRequest request) {

        log.info("Creating rating for tripId={}, userId={}", tripId, userId);

        Rating rating = RatingMapper.toEntity(request, tripId, userId);
        rating = ratingRepository.save(rating);

        log.info("Rating created with ratingId={}", rating.getRatingId());

        return RatingMapper.toResponse(rating);
    }
}
