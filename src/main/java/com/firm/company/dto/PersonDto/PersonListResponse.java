package com.firm.company.dto.PersonDto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@NoArgsConstructor
public class PersonListResponse {
    private String personName;
    private String title;
    private String unit;
    private BigDecimal price;
    private String companyName;
}
