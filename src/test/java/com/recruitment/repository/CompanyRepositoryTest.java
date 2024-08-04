package com.recruitment.repository;

import com.recruitment.entity.Company;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    @DisplayName("회사 생성 테스트")
    public void createCompany() {
        Company company = Company.builder()
                .companyId(1L)
                .country("한국")
                .name("원티드")
                .region("판교")
                .build();

        companyRepository.save(company);
    }

}
