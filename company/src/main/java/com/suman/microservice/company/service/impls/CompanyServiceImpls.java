package com.suman.microservice.company.service.impls;

import com.suman.microservice.company.entity.Company;
import com.suman.microservice.company.repository.CompanyRepository;
import com.suman.microservice.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpls implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getSingleCompany(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow();
    }

    @Override
    public Boolean createCompany(Company company) {
        try {
        companyRepository.save(company);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean updateCompany(Long companyId, Company company) {
        try{
            Company company1=companyRepository.findById(companyId).orElseThrow();
            company1.setCompanyName(company.getCompanyName());
            company1.setCompanyDescription(company.getCompanyDescription());
            companyRepository.save(company1);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public Boolean deleteCompany(Long companyId) {
        try {
            if (companyRepository.existsById(companyId)){
        companyRepository.deleteById(companyId);
            return true;
            }
            return false;
        }
        catch (Exception e){
            return false;
        }
    }
}
