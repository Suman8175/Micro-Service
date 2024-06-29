package com.suman.microservice.review.mapper;

import com.suman.microservice.review.dto.ReviewWithJobDTO;
import com.suman.microservice.review.entity.Review;
import com.suman.microservice.review.external.Job;

public class ReviewMapper {
    public static ReviewWithJobDTO mapReviewWithJob(Review review, Job job){
        ReviewWithJobDTO reviewWithJobDTO=new ReviewWithJobDTO();
        reviewWithJobDTO.setReviewId(review.getReviewId());
        reviewWithJobDTO.setReviewStars(review.getReviewStars());
        reviewWithJobDTO.setReviewDescription(review.getReviewDescription());
        reviewWithJobDTO.setJob(job);
        return reviewWithJobDTO;
    }
}
