package com.firm.company.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firm.company.dto.CompanyDto.AddNewCompanyRequestDto;
import com.firm.company.dto.CompanyDto.CompanyResponse;
import com.firm.company.dto.CompanyDto.CompanyListResponse;
import com.firm.company.dto.CompanyDto.DeleteCompanyRequestDto;
import com.firm.company.dto.CompanyDto.UpdateCompanyRequestDto;
import com.firm.company.service.companyservice.CompanyService;

@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value = "/companylist")
    public ResponseEntity<List<CompanyListResponse>> getAllCompanies() {
        return ResponseEntity.ok().body(companyService.getCompanyList());
    }

    @PostMapping(value = "/newcompany")
    public ResponseEntity<CompanyResponse> addNewCompany(@RequestBody AddNewCompanyRequestDto requestDto) {
        return ResponseEntity.ok().body(companyService.addNewCompany(requestDto));
    }

    @DeleteMapping(value = "/deletecompany")
    public ResponseEntity<CompanyResponse> deleteCompany(@RequestBody DeleteCompanyRequestDto requestDto) {
        return ResponseEntity.ok().body(companyService.deleteCompany(requestDto));
    }

    @PutMapping(value = "/upadatecompany")
    public ResponseEntity<CompanyResponse> updateCompany(@RequestBody UpdateCompanyRequestDto requestDto) {
        return ResponseEntity.ok().body(companyService.updateCompany(requestDto));
    }
}
