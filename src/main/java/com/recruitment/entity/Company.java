package com.recruitment.entity;

import com.recruitment.dto.CompanyDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;            //회사 id (자동 증가)

    private String name;        //회사 이름

    private String country;     //회사 나라

    private String region;      //회사 지역


    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobPosition> jobPositions = new ArrayList<>();


    public static Company createCompany(CompanyDTO companyDTO) {
        Company company = Company.builder()
                .name(companyDTO.getName())
                .country(companyDTO.getCountry())
                .region(companyDTO.getRegion())
                .build();

        return company;
    }

}
