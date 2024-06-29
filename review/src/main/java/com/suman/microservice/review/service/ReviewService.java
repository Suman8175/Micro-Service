package com.suman.microservice.review.service;

import com.suman.microservice.review.dto.ReviewWithJobDTO;
import com.suman.microservice.review.entity.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewWithJobDTO> getAllReview();
    ReviewWithJobDTO getReviewById(Long reviewId);

    List<Review> getAllReviewByJobId(Long jobId);

    boolean createReview(Review review);
    boolean deleteReview(Long reviewId);
    boolean updateReview(Long reviewId,Review review);

}
