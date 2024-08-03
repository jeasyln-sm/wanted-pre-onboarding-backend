package com.recruitment.service;

import com.recruitment.repository.CompanyRepository;
import com.recruitment.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final JobRepository jobPositionRepository;

}
