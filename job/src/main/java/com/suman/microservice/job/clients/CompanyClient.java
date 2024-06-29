package com.suman.microservice.job.clients;

import com.suman.microservice.job.dto.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANY-SERVICE")
public interface CompanyClient {

    @GetMapping("/companies/{id}")
     Company getCompany(@PathVariable Long id);

}
