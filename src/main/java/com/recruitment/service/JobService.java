package com.recruitment.service;

import com.recruitment.dto.JobReqDTO;
import com.recruitment.dto.JobResDTO;
import com.recruitment.entity.Company;
import com.recruitment.entity.JobPosition;
import com.recruitment.mapper.JobDTOMapper;
import com.recruitment.repository.CompanyRepository;
import com.recruitment.repository.JobPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        JobPosition job = JobDTOMapper.toEntity(jobReqDTO, company);

        jobPositionRepository.save(job);
    }

    // 채용 공고 목록 -> 전체 목록
    public List<JobResDTO> findAllJob() {
        List<JobPosition> jobs = jobPositionRepository.findAll();
        List<JobResDTO> jobResDTOS = new ArrayList<>();

        for(JobPosition jobPosition : jobs) {
            JobResDTO dto = JobDTOMapper.toDTO(jobPosition);
            jobResDTOS.add(dto);
        }

        return jobResDTOS;
    }


    // 채용 공고 수정

    // 채용 공고 삭제

}
