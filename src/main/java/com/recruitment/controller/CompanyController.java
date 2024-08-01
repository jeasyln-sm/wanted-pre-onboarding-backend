package com.recruitment.controller;

import com.recruitment.dto.CompanyDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController {

    @GetMapping("/register")
    public String createCompany() {
        return "company/register";
    }


    @PostMapping("/registerOk")
    public CompanyDTO register(CompanyDTO companyDTO) {
        return companyDTO;
    }
}
