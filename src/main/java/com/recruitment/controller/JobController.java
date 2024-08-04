package com.recruitment.controller;

import com.recruitment.dto.JobReqDTO;
import com.recruitment.dto.JobResDTO;
import com.recruitment.entity.JobPosition;
import com.recruitment.service.CompanyService;
import com.recruitment.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;
    private final CompanyService companyService;


    // 채용 공고 등록 -> Form으로 이동
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("jobReqDto", new JobReqDTO());
        model.addAttribute("companies", companyService.finaAllCompanies());
        return "JobPosition/regForm";
    }

    // 채용 공고 등록
    @PostMapping("/new")
    public String createJobPosition(@ModelAttribute JobReqDTO jobReqDTO) {
        jobService.createJob(jobReqDTO);
        return "redirect:/";
    }

    // 채용 공고 목록 -> 전체 목록
    @GetMapping("/list")
    public String showJobList(Model model) {
        List<JobResDTO> jobs = jobService.findAllJob();
        model.addAttribute("jobs", jobs);
        return "JobPosition/positionList";
    }


    // 채용 공고 상세 페이지
    @GetMapping("/job/{id}")
    public String showDetail(@PathVariable("id") Long jobPositionId, Model model) {
        JobResDTO jobResDTO = jobService.findById(jobPositionId);
        model.addAttribute("jobDetail", jobResDTO);
        return "JobPosition/jobDetail";
    }


    // 채용 공고 수정

    // 채용 공고 삭제

}
