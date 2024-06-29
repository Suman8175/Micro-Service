package com.suman.microservice.review.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Review {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long reviewId;
private Integer reviewStars;
private String reviewDescription;
private Long jobId;
}
