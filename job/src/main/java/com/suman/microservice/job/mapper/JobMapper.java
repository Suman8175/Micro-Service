package com.suman.microservice.job.mapper;

import com.suman.microservice.job.dto.Company;
import com.suman.microservice.job.dto.JobWithCompanyDTO;
import com.suman.microservice.job.dto.Review;
import com.suman.microservice.job.entity.Job;

import java.util.List;

public class JobMapper {
    public static JobWithCompanyDTO mapjobWithCompanyDTO(Job job, Company company, List<Review> reviews){
        JobWithCompanyDTO jobWithCompanyDTO=new JobWithCompanyDTO();
        jobWithCompanyDTO.setJobId(job.getJobId());
        jobWithCompanyDTO.setJobName(job.getJobName());
        jobWithCompanyDTO.setJobDescription(job.getJobDescription());
        jobWithCompanyDTO.setCompany(company);
        jobWithCompanyDTO.setReviews(reviews);
        return jobWithCompanyDTO;
    }

}
