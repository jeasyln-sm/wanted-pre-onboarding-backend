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
public class JobReqDTO {

    private Long companyId;
    private String position;
    private int reward;
    private String content;
    private String language;

}
