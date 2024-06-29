package com.suman.microservice.job.dto;

import com.suman.microservice.job.entity.Job;
import lombok.Data;

import java.util.List;

@Data
public class JobWithCompanyDTO {
    private  Long jobId;
    private String jobName;
    private String jobDescription;
    private Company company;
    private List<Review> reviews;
}
