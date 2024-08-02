package com.recruitment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class JobPositionDTO {

    // 채용 공고 등록 dto
    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Builder
    public static class Request {
        private Long CompanyId;
        private String position;
        private int reward;
        private String content;
        private String language;
    }

    // 채용 공고 목록 dto
    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Builder
    public static class Response {
        private Long id;
        private String companyName;
        private String country;
        private String region;
        private String position;
        private int reward;
        private String content;
        private String language;
    }
}
