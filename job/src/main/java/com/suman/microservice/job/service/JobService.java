package com.suman.microservice.job.service;

import com.suman.microservice.job.dto.JobWithCompanyDTO;
import com.suman.microservice.job.entity.Job;

import java.util.List;

public interface JobService {

    List<JobWithCompanyDTO> getAllJobs();
//    JobWithCompanyDTO getJobById(Long jobId);
    Job getJobById(Long jobId);

    boolean createJob(Job job);
    boolean deleteJob(Long jobId);
    boolean updateJob(Long jobId,Job job);

}
