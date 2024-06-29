package com.suman.microservice.job.controller;

import com.suman.microservice.job.entity.Job;
import com.suman.microservice.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping()
    public ResponseEntity<?> getAllJobs(){
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @GetMapping({"/{jobId}"})
    public ResponseEntity<?> getJobById(@PathVariable Long jobId){
        return new ResponseEntity<>(jobService.getJobById(jobId),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> createJob (@RequestBody Job job){
        return new ResponseEntity<>(jobService.createJob(job),HttpStatus.CREATED);
    }
    @PutMapping("/{jobId}")
    public ResponseEntity<?> updateJob (@PathVariable Long jobId,@RequestBody Job job){
        return new ResponseEntity<>(jobService.updateJob(jobId,job),HttpStatus.OK);
    }

    @DeleteMapping ("/{jobId}")
    public ResponseEntity<?> deleteJob (@PathVariable Long jobId){
        return new ResponseEntity<>(jobService.deleteJob(jobId),HttpStatus.OK);
    }
}
