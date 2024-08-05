package com.recruitment.repository;

import com.recruitment.entity.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPositionRepository extends JpaRepository<JobPosition, Long> {

    // 회사 ID로 채용 공고를 찾는 쿼리
    List<JobPosition> findByCompany_CompanyId(Long companyId);

    // 회사명으로 검색
    List<JobPosition> findByCompany_NameContainingIgnoreCase(String companyName);

    // 포지션으로 검색
    List<JobPosition> findByPositionContainingIgnoreCase(String position);

    // 사용 언어로 검색
    List<JobPosition> findByLanguageContainingIgnoreCase(String language);

    // 국가로 검색
    List<JobPosition> findByCompany_CountryContainingIgnoreCase(String country);

    // 지역으로 검색
    List<JobPosition> findByCompany_RegionContainingIgnoreCase(String region);

}
