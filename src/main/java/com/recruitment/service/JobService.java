package com.recruitment.service;

import com.recruitment.dto.JobReqDTO;
import com.recruitment.dto.JobResDTO;
import com.recruitment.entity.Company;
import com.recruitment.entity.JobPosition;
import com.recruitment.repository.CompanyRepository;
import com.recruitment.repository.JobPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {

    private final CompanyRepository companyRepository;
    private final JobPositionRepository jobPositionRepository;



    // 채용 공고 등록
    public void createJob(JobReqDTO jobReqDTO) {
        Long companyId = jobReqDTO.getCompanyId();

        // Company ID를 사용하여 Company 객체를 조회
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("회사 ID가 존재하지 않습니다."));

        JobPosition job = new JobPosition();
        job.setCompany(company);
        job.setPosition(jobReqDTO.getPosition());
        job.setReward(jobReqDTO.getReward());
        job.setContent(jobReqDTO.getContent());
        job.setLanguage(jobReqDTO.getLanguage());

        jobPositionRepository.save(job);
    }

    // 채용 공고 목록 -> 전체 목록
    public List<JobResDTO> findAllJob() {
        List<JobPosition> jobs = jobPositionRepository.findAll();
        return jobs.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private JobResDTO convertToDTO(JobPosition jobPosition) {
        Company company = jobPosition.getCompany();
        return new JobResDTO(
                jobPosition.getJobPositionId(),
                company.getName(),
                company.getCountry(),
                company.getRegion(),
                jobPosition.getPosition(),
                jobPosition.getReward(),
                jobPosition.getLanguage()
        );
    }

    // 채용 공고 수정

    // 채용 공고 삭제

}
