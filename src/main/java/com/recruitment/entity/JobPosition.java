package com.recruitment.entity;

import com.recruitment.dto.JobReqDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobPositionId;                //채용id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;        //채용회사

    private String position;        //채용포지션

    private int reward;             //채용보상금

    @Lob
    private String content;         //채용내용

    private String language;        //채용언어


    public static JobPosition createJobPosition(JobReqDTO jobReqDTO, Company company) {
        JobPosition jobPosition = JobPosition.builder()
                .company(company)
                .position(jobReqDTO.getPosition())
                .reward(jobReqDTO.getReward())
                .content(jobReqDTO.getContent())
                .language(jobReqDTO.getLanguage())
                .build();

        return jobPosition;
    }
}
