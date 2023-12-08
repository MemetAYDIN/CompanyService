package com.firm.company.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.firm.company.dto.PersonDto.NewPersonRequestDto;
import com.firm.company.entity.Person;

@Mapper(uses = { CompanyMapper.class })
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toPersonEntity(NewPersonRequestDto requestDto);
}
