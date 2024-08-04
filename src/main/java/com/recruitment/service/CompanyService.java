package com.recruitment.service;

import com.recruitment.entity.Company;
import com.recruitment.repository.CompanyRepository;
import com.recruitment.repository.JobPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final JobPositionRepository jobPositionRepository;


    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

}
