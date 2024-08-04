package com.recruitment.mapper;

import com.recruitment.dto.JobResDTO;
import com.recruitment.entity.Company;
import com.recruitment.entity.JobPosition;

public class JobDTOMapper {

    public static JobResDTO toDTO(JobPosition jobPosition) {
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
}
