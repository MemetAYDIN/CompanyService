package com.firm.company.dto.CompanyDto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class AddNewCompanyRequestDto {

    private String companyName;
}
