package com.suman.microservice.company.controller;

import com.suman.microservice.company.entity.Company;
import com.suman.microservice.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<?> getCompanies(){
        List<Company> allCompanies = companyService.getAllCompanies();
        return new ResponseEntity<>(allCompanies,HttpStatus.OK);
    }
    @GetMapping("/{companyId}")
    public ResponseEntity<?> getCompanyWithId(@PathVariable Long companyId){
        return new ResponseEntity<>(companyService.getSingleCompany(companyId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCompany(@RequestBody Company company){
        Boolean condition = companyService.createCompany(company);
        return condition ? new ResponseEntity<>("Added",HttpStatus.CREATED) : new ResponseEntity<>("Failed to create",HttpStatus.OK);
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<?> deleteCompany( @PathVariable Long companyId){
        Boolean condition = companyService.deleteCompany(companyId);
        return condition ? new ResponseEntity<>("Deleted",HttpStatus.OK) :new ResponseEntity<>("Failed",HttpStatus.OK);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<?> updateCompany (@PathVariable Long companyId,@RequestBody Company company){
        Boolean condition = companyService.updateCompany(companyId, company);
        return condition ? new ResponseEntity<>("Edited",HttpStatus.OK) : new ResponseEntity<>("Failed to create",HttpStatus.OK);

    }

}
