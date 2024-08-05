package com.recruitment.repository;

import com.recruitment.entity.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPositionRepository extends JpaRepository<JobPosition, Long> {

    // 회사 ID로 채용 공고를 찾는 쿼리
    List<JobPosition> findByCompany_CompanyId(Long companyId);

    // 채용 공고 검색
    List<JobPosition> findByPositionContainingIgnoreCaseOrLanguageContainingIgnoreCaseOrCompany_NameContainingIgnoreCase(
        String position, String language, String companyName);

}
