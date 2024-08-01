package com.recruitment.entity;

import com.recruitment.dto.CompanyDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;            //회사_id

    @Column(nullable = false)
    private String position;    //채용포지션

    @Column(nullable = false)
    private int compensation;   //채용보상금

    @Column(nullable = false)
    private String content;     //채용내용

    @Column(nullable = false)
    private String language;    //사용기술


    public static Company createCompany(CompanyDTO companyDTO) {
        Company company = Company.builder()
                .position(companyDTO.getPosition())
                .compensation(companyDTO.getCompensation())
                .content(companyDTO.getContent())
                .language(companyDTO.getLanguage())
                .build();

        return company;
    }

}
