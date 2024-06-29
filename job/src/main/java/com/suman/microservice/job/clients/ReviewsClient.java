package com.suman.microservice.job.clients;

import com.suman.microservice.job.dto.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEW")
public interface ReviewsClient {
    @GetMapping("/reviews")
    List<Review> getListOfReviews(@RequestParam Long jobId);
}
