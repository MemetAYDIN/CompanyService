package com.firm.company.dto.PersonDto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class NewPersonRequestDto {
    private String personName;
    private String title;
    private String unit;
    private BigDecimal price;
    private Long companyId;
    private Long personIdentity;
}
