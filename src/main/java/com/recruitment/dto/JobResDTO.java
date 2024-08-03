package com.recruitment.dto;

import com.recruitment.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
