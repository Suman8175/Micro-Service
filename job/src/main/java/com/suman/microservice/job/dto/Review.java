package com.suman.microservice.job.dto;

import lombok.Data;

@Data
public class Review {
    private Long reviewId;
    private Integer reviewStars;
    private String reviewDescription;
}
