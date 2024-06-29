package com.suman.microservice.review.dto;

import com.suman.microservice.review.entity.Review;
import com.suman.microservice.review.external.Job;
import lombok.Data;

@Data
public class ReviewWithJobDTO {
    private Long reviewId;
    private Integer reviewStars;
    private String reviewDescription;
    private Job job;
}
