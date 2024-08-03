package com.recruitment.service;

import com.recruitment.repository.CompanyRepository;
import com.recruitment.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {

    private final CompanyRepository companyRepository;
    private final JobRepository jobPositionRepository;

    // Entity -> DTO


    // 채용 공고 등록
//    @Transactional
//    public JobPositionDTO regPosition(JobPositionDTO jobPositionDTO) {
//        Company company = companyRepository.findById(jobPositionDTO.getCompanyId()).orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + jobPositionDTO.getCompanyId()));
//
//    }

    // 채용 공고 목록

    // 채용 공고 수정

    // 채용 공고 삭제

}
