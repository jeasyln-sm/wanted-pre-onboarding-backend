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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {

    private final CompanyRepository companyRepository;
    private final JobPositionRepository jobPositionRepository;


    // 채용 공고 등록
    @Transactional
    public void createJob(JobReqDTO jobReqDTO) {
        Long companyId = jobReqDTO.getCompanyId();

        // Company ID를 사용하여 Company 객체를 조회
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("회사 ID가 존재하지 않습니다."));

        JobPosition job = JobDTOMapper.toEntity(jobReqDTO, company);

        jobPositionRepository.save(job);
    }

    // 채용 공고 목록 -> 전체 목록
    @Transactional
    public List<JobResDTO> findAllJob() {
        List<JobPosition> jobs = jobPositionRepository.findAll();
        List<JobResDTO> jobResDTOS = new ArrayList<>();

        for(JobPosition jobPosition : jobs) {
            JobResDTO dto = JobDTOMapper.toDTO(jobPosition);
            jobResDTOS.add(dto);
        }

        return jobResDTOS;
    }


    // 채용 공고 상세 페이지 보기
    @Transactional
    public JobResDTO findById(Long jobPositionId) {
        JobPosition jobPosition = jobPositionRepository.findById(jobPositionId)
                .orElseThrow(() -> new IllegalArgumentException("채용 공고 ID가 존재하지 않습니다."));

        // 현재 채용 공고의 회사의 다른 채용 공고 ID를 조회
        List<Long> otherJobIds = jobPosition.getCompany().getJobPositions().stream()
                .filter(job -> !job.getJobPositionId().equals(jobPositionId)) // 현재 채용 공고 제외
                .map(JobPosition::getJobPositionId)
                .collect(Collectors.toList());

        // JobResDTO에 다른 채용 공고 ID를 설정
        JobResDTO jobResDTO = JobDTOMapper.toDTO(jobPosition);
        jobResDTO.setOtherJobIds(otherJobIds);

        return jobResDTO;
    }


    // 채용 공고 수정
    @Transactional
    public void updateJobPosition(Long jobPositionId, JobReqDTO jobReqDTO) {
        JobPosition jobPosition = jobPositionRepository.findById(jobPositionId)
                .orElseThrow(() -> new IllegalArgumentException("채용 공고 ID가 존재하지 않습니다."));

        JobDTOMapper.updateEntity(jobReqDTO, jobPosition);
        jobPositionRepository.save(jobPosition);
    }


    // 채용 공고 삭제
    @Transactional
    public void deleteJob(Long jobPositionId) {
        JobPosition jobPosition = jobPositionRepository.findById(jobPositionId)
                .orElseThrow(() -> new IllegalArgumentException("채용 공고 ID가 존재하지 않습니다."));

        jobPositionRepository.delete(jobPosition);
    }


    // 채용 공고 검색
    @Transactional
    public List<JobResDTO> searchJobPositions(String search) {
        // JPQL 쿼리에서 검색 조건을 사용하여 JobPosition 엔티티를 조회
        List<JobPosition> jobPositions = jobPositionRepository.findByPositionContainingIgnoreCaseOrLanguageContainingIgnoreCaseOrCompany_NameContainingIgnoreCase(
                search, search, search);

        // JobPosition 엔티티를 JobResDTO로 변환
        List<JobResDTO> jobResDTOs = new ArrayList<>();
        for (JobPosition jobPosition : jobPositions) {
            JobResDTO dto = JobDTOMapper.toDTO(jobPosition);
            jobResDTOs.add(dto);
        }

        return jobResDTOs;
    }

}
