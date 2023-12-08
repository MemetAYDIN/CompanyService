package com.firm.company.service.companyservice;

import java.util.List;

import com.firm.company.dto.CompanyDto.AddNewCompanyRequestDto;
import com.firm.company.dto.CompanyDto.CompanyResponse;
import com.firm.company.dto.CompanyDto.CompanyListResponse;
import com.firm.company.dto.CompanyDto.DeleteCompanyRequestDto;
import com.firm.company.dto.CompanyDto.UpdateCompanyRequestDto;

import jakarta.validation.Valid;

public interface CompanyService {
    public List<CompanyListResponse> getCompanyList();

    public CompanyResponse addNewCompany(@Valid AddNewCompanyRequestDto requestDto);

    public CompanyResponse updateCompany(@Valid UpdateCompanyRequestDto requestDto);

    public CompanyResponse deleteCompany(@Valid DeleteCompanyRequestDto requestDto);

}
