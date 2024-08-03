package com.recruitment.service;

import com.recruitment.entity.Company;
import com.recruitment.repository.CompanyRepository;
import com.recruitment.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final JobRepository jobPositionRepository;


    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

}
