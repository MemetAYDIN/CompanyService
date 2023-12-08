package com.firm.company.dto.PersonDto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import com.firm.company.entity.Company;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class PersonUpdateRequestDto {
    private String personName;
    private String title;
    private String unit;
    private BigDecimal price;
    private Long personIdentity;
    private String companyName;
}
