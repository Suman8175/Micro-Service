package com.suman.microservice.job.service.impls;

import com.suman.microservice.job.clients.CompanyClient;
import com.suman.microservice.job.clients.ReviewsClient;
import com.suman.microservice.job.dto.Company;
import com.suman.microservice.job.dto.JobWithCompanyDTO;
import com.suman.microservice.job.dto.Review;
import com.suman.microservice.job.entity.Job;
import com.suman.microservice.job.repository.JobRepository;
import com.suman.microservice.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.suman.microservice.job.mapper.JobMapper.mapjobWithCompanyDTO;

@Service
@RequiredArgsConstructor
public class JobServiceImpls implements JobService {
    private final JobRepository jobRepository;
    private final RestTemplate restTemplate;
    private final CompanyClient companyClient;
    private final ReviewsClient reviewsClient;


    @Override
    public List<JobWithCompanyDTO> getAllJobs() {
     List<Job> jobs=  jobRepository.findAll();

     return jobs.stream().map((job -> getCompany(job))).collect(Collectors.toList());
    }

    private JobWithCompanyDTO getCompany(Job job) {
//        Company forObject = restTemplate.getForObject("http://COMPANY-SERVICE:8080/companies/" + job.getCompanyId(), Company.class);

        Company forObject=companyClient.getCompany(job.getCompanyId());


//        ResponseEntity<List<Review>> responseReview = restTemplate.exchange("http://REVIEW:8082/reviews?jobId=" + job.getJobId(),
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Review>>() {
//                }
//        );
//        List<Review> body = responseReview.getBody();

        List<Review> body =  reviewsClient.getListOfReviews(job.getJobId());


        return mapjobWithCompanyDTO(job,forObject,body);
    }

//    @Override
//    public JobWithCompanyDTO getJobById(Long jobId) {
//        JobWithCompanyDTO jobWithCompanyDTO=new JobWithCompanyDTO();
//        Job job = jobRepository.findById(jobId).orElse(null);
//        jobWithCompanyDTO.setJob(job);
//        assert job != null;
//        jobWithCompanyDTO.setCompany(restTemplate.getForObject("http://COMPANY-SERVICE:8080/companies/"+job.getCompanyId(),Company.class));
//        return jobWithCompanyDTO;
//    }
    @Override
    public Job getJobById(Long jobId){
        return jobRepository.findById(jobId).orElse(null);
    }

    @Override
    public boolean createJob(Job job) {
        try {
         jobRepository.save(job);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteJob(Long jobId) {
        if (jobRepository.existsById(jobId)) {
            jobRepository.deleteById(jobId);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean updateJob(Long jobId, Job job) {
            if (jobRepository.existsById(jobId)){
                Job job1 = jobRepository.findById(jobId).orElseThrow();
                job1.setJobName(job.getJobName());
                job1.setJobDescription(job.getJobDescription());
                jobRepository.save(job1);
                return true;
            }
            return false;
    }
}
