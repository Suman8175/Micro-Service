package com.suman.microservice.company.service;

import com.suman.microservice.company.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    Company getSingleCompany(Long companyId);

    Boolean createCompany(Company company);

    Boolean updateCompany(Long companyId,Company company);

    Boolean deleteCompany(Long companyId);

}
