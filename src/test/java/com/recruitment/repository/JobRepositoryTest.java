package com.recruitment.repository;

import com.recruitment.entity.Company;
import com.recruitment.entity.JobPosition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobRepositoryTest {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    @DisplayName("생성 테스트")
    public void createJobTest() {
        Company company = Company.builder()
                .id(8L)
                .country("한국")
                .name("원티드")
                .region("판교")
                .build();

        companyRepository.save(company);

        JobPosition job = JobPosition.builder()
                .id(1L)
                .company(company)
                .position("백엔드 주니어 개발자")
                .reward(1000000)
                .content("원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..")
                .language("Python")
                .build();

        System.out.println("Job: " + job);
        jobRepository.save(job);
    }

}
