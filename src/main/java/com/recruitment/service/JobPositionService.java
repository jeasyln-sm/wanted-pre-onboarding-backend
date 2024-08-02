package com.recruitment.service;

import com.recruitment.repository.CompanyRepository;
import com.recruitment.repository.JobPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobPositionService {

    private final CompanyRepository companyRepository;
    private final JobPositionRepository jobPositionRepository;
}
