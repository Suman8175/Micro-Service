package com.suman.microservice.review.external;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Job {
    private  Long jobId;
    private String jobName;
    private String jobDescription;
    private Long companyId;
}
