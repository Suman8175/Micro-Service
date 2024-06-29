package com.suman.microservice.review.controller;

import com.suman.microservice.review.entity.Review;
import com.suman.microservice.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping()
    public ResponseEntity<?> createReview( @RequestBody Review review){
       return reviewService.createReview(review) ? new ResponseEntity<>("Created", HttpStatus.CREATED)
               :new ResponseEntity<>("Failed",HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllReviews(){
        return new ResponseEntity<>(reviewService.getAllReview(),HttpStatus.OK);
    }
    @GetMapping(params = "jobId")
    public ResponseEntity<?> getByJobId(@RequestParam Long jobId){
    return new ResponseEntity<>(reviewService.getAllReviewByJobId(jobId),HttpStatus.OK);
    }
    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReviewById(reviewId),HttpStatus.OK);
    }


    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId,@RequestBody Review review){
        return reviewService.updateReview(reviewId,review) ?new ResponseEntity<>("Updated",HttpStatus.OK)
                :new ResponseEntity<>("Failed",HttpStatus.OK);
    }
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long reviewId){
        return reviewService.deleteReview(reviewId) ? new ResponseEntity<>("Deleted",HttpStatus.OK)
                :new ResponseEntity<>("Failed",HttpStatus.OK);
    }

}
