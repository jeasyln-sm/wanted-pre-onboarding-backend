package com.recruitment.repository;

import com.recruitment.entity.Company;
import com.recruitment.entity.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<JobPosition, Long> {

    // 채용 회사로 검색
    Optional<JobPosition> findByCompany(Company company);

    // 채용 포지션으로 검색
    Optional<JobPosition> findByPosition(String Position);

    // 포지션or내용에 키워드 포함
    Optional<JobPosition> findByPositionContainingOrContentContaining(String position, String content);

}
