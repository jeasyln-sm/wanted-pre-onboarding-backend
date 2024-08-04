package com.recruitment.service;

import com.recruitment.dto.JobReqDTO;
import com.recruitment.entity.Company;
import com.recruitment.entity.JobPosition;
import com.recruitment.repository.CompanyRepository;
import com.recruitment.repository.JobPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {

    private final CompanyRepository companyRepository;
    private final JobPositionRepository jobPositionRepository;



    // 채용 공고 등록
    public void createJob(JobReqDTO jobReqDTO) {
        Long companyId = jobReqDTO.getCompanyId();
        System.out.println("회사 ID: " + companyId);  // 로그 출력

        // Company ID를 사용하여 Company 객체를 조회합니다
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("회사 ID가 존재하지 않습니다."));

        JobPosition job = new JobPosition();
        job.setCompany(company);  // 조회한 Company 객체를 설정합니다
        job.setPosition(jobReqDTO.getPosition());
        job.setReward(jobReqDTO.getReward());
        job.setContent(jobReqDTO.getContent());
        job.setLanguage(jobReqDTO.getLanguage());

        jobPositionRepository.save(job);
    }

    // 채용 공고 목록

    // 채용 공고 수정

    // 채용 공고 삭제

}
