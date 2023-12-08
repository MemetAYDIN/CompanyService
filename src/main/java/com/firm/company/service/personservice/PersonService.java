package com.firm.company.service.personservice;

import java.util.List;

import com.firm.company.dto.PersonDto.DeletePersonRequest;
import com.firm.company.dto.PersonDto.NewPersonRequestDto;
import com.firm.company.dto.PersonDto.PersonListResponse;
import com.firm.company.dto.PersonDto.PersonResponse;
import com.firm.company.dto.PersonDto.PersonUpdateRequestDto;

import jakarta.validation.Valid;

public interface PersonService {

    public List<PersonListResponse> getCompanyList();

    public PersonResponse addNewPerson(@Valid NewPersonRequestDto requestDto);

    public PersonResponse updatePerson(@Valid PersonUpdateRequestDto requestDto);

    public PersonResponse deletePerson(@Valid DeletePersonRequest requestDto);

}
