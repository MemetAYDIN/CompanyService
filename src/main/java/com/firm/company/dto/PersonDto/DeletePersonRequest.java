package com.firm.company.dto.PersonDto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class DeletePersonRequest {
    private Long personIdentity;
}
