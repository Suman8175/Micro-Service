package com.suman.microservice.review.clients;

import com.suman.microservice.review.external.Job;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "JOB-SERVICE")
public interface JobClient {
    @GetMapping("/jobs/{id}")
     Job getJobById(@PathVariable Long id);
}
