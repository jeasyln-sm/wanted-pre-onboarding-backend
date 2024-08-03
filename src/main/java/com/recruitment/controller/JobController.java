package com.recruitment.controller;

import com.recruitment.dto.JobReqDTO;
import com.recruitment.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JobController {

    private final JobService jobPositionService;

    // 채용 공고 등록 -> Form으로 이동
    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("jobPosition", new JobReqDTO());
        return "JobPosition/regForm";
    }

    // 채용 공고 등록
    @PostMapping("/register")
    public String regJob() {
        return "redirect:/positionList";
    }

    // 채용 공고 목록 -> 전체 목록
    @GetMapping("/list")
    public String getAllJobPosition(Model model) {
        return "JobPosition/positionList";
    }

    // 채용 공고 수정

    // 채용 공고 삭제

}
