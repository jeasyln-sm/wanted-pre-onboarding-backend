package com.recruitment.mapper;

import com.recruitment.dto.JobReqDTO;
import com.recruitment.dto.JobResDTO;
import com.recruitment.entity.Company;
import com.recruitment.entity.JobPosition;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;

@UtilityClass
public class JobDTOMapper {

    //JobReqDTO
    public static JobPosition toEntity(JobReqDTO jobReqDTO, Company company) {
        return JobPosition.builder()
                .company(company)
                .position(jobReqDTO.getPosition())
                .reward(jobReqDTO.getReward())
                .content(jobReqDTO.getContent())
                .language(jobReqDTO.getLanguage())
                .build();
    }


    //JobResDTO
    public static JobResDTO toDTO(JobPosition jobPosition) {
        Company company = jobPosition.getCompany();

        return new JobResDTO(
                jobPosition.getJobPositionId(),
                company.getName(),
                company.getCountry(),
                company.getRegion(),
                jobPosition.getPosition(),
                jobPosition.getReward(),
                jobPosition.getLanguage(),
                jobPosition.getContent(),
                new ArrayList<>() // 빈 리스트를 반환
        );
    }


    // update
    public static JobPosition updateEntity(JobReqDTO jobReqDTO, JobPosition jobPosition) {
        jobPosition.setPosition(jobReqDTO.getPosition());
        jobPosition.setReward(jobReqDTO.getReward());
        jobPosition.setContent(jobReqDTO.getContent());
        jobPosition.setLanguage(jobReqDTO.getLanguage());

        return jobPosition;
    }
}
