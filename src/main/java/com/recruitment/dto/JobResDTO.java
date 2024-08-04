package com.recruitment.dto;

import com.recruitment.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobResDTO {

    private Long jobPositionId;
    private String companyName;
    private String country;
    private String region;
    private String position;
    private int reward;
    private String language;
    private String content;
    private List<Long> otherJobIds;  // 같은 회사 다른 채용 공고

}
