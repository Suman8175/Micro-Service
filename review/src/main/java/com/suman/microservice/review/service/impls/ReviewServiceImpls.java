package com.suman.microservice.review.service.impls;

import com.suman.microservice.review.clients.JobClient;
import com.suman.microservice.review.dto.ReviewWithJobDTO;
import com.suman.microservice.review.external.Job;
import com.suman.microservice.review.entity.Review;
import com.suman.microservice.review.repository.ReviewRepository;
import com.suman.microservice.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.suman.microservice.review.mapper.ReviewMapper.mapReviewWithJob;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpls implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestTemplate restTemplate;
    private final JobClient jobClient;

    //This is one way
//    @Override
//    public List<ReviewWithJobDTO> getAllReview() {
//        List<ReviewWithJobDTO> collectors=new ArrayList<>();
//
//        List<Review> allReviews = reviewRepository.findAll();
//
//        for (Review review:allReviews){
//            ReviewWithJobDTO mapper=new ReviewWithJobDTO();
//            mapper.setReview(review);
//            Job job = restTemplate.getForObject("http://JOB-SERVICE:8081/jobs/"+review.getJobId(), Job.class);
//            mapper.setJob(job);
//            collectors.add(mapper);
//        }
//        return collectors;
//    }
    @Override
    public List<ReviewWithJobDTO> getAllReview() {
        List<Review> allReviews = reviewRepository.findAll();
        return allReviews.stream()
//                .map(this::mapReviewToDTO) same as
                .map(review -> mapReviewToDTO(review))
                .collect(Collectors.toList());
    }

    private ReviewWithJobDTO mapReviewToDTO(Review review) {
        return mapReviewWithJob(review,getJobForReview(review));

    }

    @Cacheable("jobs")
    public Job getJobForReview(Review review) {
//        return restTemplate.getForObject("http://JOB-SERVICE:8081/jobs/" + review.getJobId(), Job.class);
        jobClient.getJobById(review.getJobId());
        return null;
    }

    @Override
    public ReviewWithJobDTO getReviewById(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new RuntimeException("no data"));
      return   mapReviewToDTO(review);
    }

    @Override
    public List<Review> getAllReviewByJobId(Long jobId) {
//        reviewRepository.findByJobId(jobId); same
        List<Review> all = reviewRepository.findAll();
        List<Review> filteredReviews = all.stream().filter(review -> review.getJobId().equals(jobId)).toList();
        return filteredReviews.isEmpty() ? null : filteredReviews;
    }

    @Override
    public boolean createReview(Review review) {
        try{
         reviewRepository.save(review);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long reviewId) {
           if (reviewRepository.existsById(reviewId)){
           reviewRepository.deleteById(reviewId);
           return true;
       }
       return false;
    }

    @Override
    public boolean updateReview(Long reviewId, Review review) {
               Review byId = reviewRepository.findById(reviewId).orElseThrow(()-> new RuntimeException("no such method found"));
               byId.setReviewStars(review.getReviewStars());
               byId.setReviewDescription(review.getReviewDescription());
               reviewRepository.save(byId);
               return true;
    }
}
