package com.firm.company.service.companyservice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.firm.company.dto.CompanyDto.AddNewCompanyRequestDto;
import com.firm.company.dto.CompanyDto.CompanyResponse;
import com.firm.company.dto.CompanyDto.CompanyListResponse;
import com.firm.company.dto.CompanyDto.DeleteCompanyRequestDto;
import com.firm.company.dto.CompanyDto.UpdateCompanyRequestDto;
import com.firm.company.entity.Company;
import com.firm.company.exception.BusinessException;
import com.firm.company.repository.CompanyRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<CompanyListResponse> getCompanyList() {
        List<Company> companyList = companyRepository.findAll();
        if (!CollectionUtils.isEmpty(companyList)) {
            return (List<CompanyListResponse>) companyList.stream().map(entity -> CompanyListResponse.builder()
                    .companyName(entity.getCompanyName())
                    .build())
                    .toList();
        }
        throw new BusinessException("Company List is empty");
    }

    @Override
    public CompanyResponse addNewCompany(@Valid AddNewCompanyRequestDto requestDto) {
        CompanyResponse response = new CompanyResponse();
        if (!requestDto.getCompanyName().equals(null)) {
            Company company = convertToCompanyDto(requestDto);
            companyRepository.save(company);
            response.setMessage("Company Saved");
        } else {
            throw new BusinessException("Role don't have permission");
        }

        return response;
    }

    public Company convertToCompanyDto(AddNewCompanyRequestDto requestDto) {
        Company entity = new Company();
        entity.setCompanyName(requestDto.getCompanyName());
        entity.setCreatedAt(LocalDate.now());
        entity.setUpdatedAt(LocalDate.now());

        return entity;
    }

    @Override
    public CompanyResponse updateCompany(@Valid UpdateCompanyRequestDto requestDto) {

        CompanyResponse response = new CompanyResponse();
        if (!requestDto.getNewCompanyName().equals(null) && !requestDto.getOldCompanyName().equals(null)) {
            Company companyEntity = companyRepository.findByCompanyName(requestDto.getOldCompanyName());
            companyEntity.setCompanyName(requestDto.getNewCompanyName());
            companyRepository.save(companyEntity);
            response.setMessage("Company Updated");

        } else {
            throw new BusinessException("Company couldn't updated");
        }
        return response;
    }

    @Override
    public CompanyResponse deleteCompany(@Valid DeleteCompanyRequestDto requestDto) {
        CompanyResponse response = new CompanyResponse();
        if (!requestDto.getCompanyName().equals(null)) {
            Company company = companyRepository.findByCompanyName(requestDto.getCompanyName());
            companyRepository.delete(company);
            response.setMessage("Company Deleted");
        } else {
            throw new BusinessException("Check Company Name '");
        }

        return response;
    }

}
