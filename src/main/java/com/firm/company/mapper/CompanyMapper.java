package com.firm.company.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.firm.company.dto.CompanyDto.AddNewCompanyRequestDto;
import com.firm.company.entity.Company;

@Mapper
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    Company toCompanyEntity(AddNewCompanyRequestDto companyRequestDto);

}
