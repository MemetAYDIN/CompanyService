package com.firm.company.service.personservice;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.firm.company.dto.CompanyDto.CompanyResponse;
import com.firm.company.dto.CompanyDto.DeleteCompanyRequestDto;
import com.firm.company.dto.CompanyDto.UpdateCompanyRequestDto;
import com.firm.company.dto.PersonDto.DeletePersonRequest;
import com.firm.company.dto.PersonDto.NewPersonRequestDto;
import com.firm.company.dto.PersonDto.PersonListResponse;
import com.firm.company.dto.PersonDto.PersonResponse;
import com.firm.company.dto.PersonDto.PersonUpdateRequestDto;
import com.firm.company.entity.Company;
import com.firm.company.entity.Person;
import com.firm.company.exception.BusinessException;
import com.firm.company.repository.CompanyRepository;
import com.firm.company.repository.PersonRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<PersonListResponse> getCompanyList() {
        List<Person> personlist = personRepository.findAll();
        if (!CollectionUtils.isEmpty(personlist)) {
            return (List<PersonListResponse>) personlist.stream().map(entity -> PersonListResponse.builder()
                    .companyName(entity.getCompany().getCompanyName())
                    .personName(entity.getPersonName())
                    .price(entity.getPrice())
                    .title(entity.getTitle())
                    .unit(entity.getUnit())
                    .build())
                    .toList();
        } else {
            throw new BusinessException("Person List is empty!!");
        }

    }

    @Override
    public PersonResponse addNewPerson(@Valid NewPersonRequestDto requestDto) {

        PersonResponse response = new PersonResponse();

        if (!requestDto.getPersonName().equals(null)) {
            Person person = convertPersonEntity(requestDto);
            personRepository.save(person);
            response.setMessage("Person Added");
        } else {
            throw new BusinessException("Check your fields!!!");
        }
        return response;

    }

    public Person convertPersonEntity(NewPersonRequestDto requestDto) {
        Person personEntity = new Person();
        personEntity.setPersonName(requestDto.getPersonName());
        personEntity.setPrice(requestDto.getPrice());
        personEntity.setUnit(requestDto.getUnit());
        personEntity.setTitle(requestDto.getTitle());
        personEntity.setCreatedAt(LocalDate.now());
        personEntity.setUpdatedAt(LocalDate.now());
        personEntity.setPersonIdentity(requestDto.getPersonIdentity());

        Company company = companyRepository.findByCompanyId(requestDto.getCompanyId());
        personEntity.setCompany(company);

        return personEntity;
    }

    @Override
    public PersonResponse updatePerson(@Valid PersonUpdateRequestDto requestDto) {
        PersonResponse response = new PersonResponse();

        if (!requestDto.getPersonIdentity().equals(null)) {
            Person person = personRepository.findByPersonIdentity(requestDto.getPersonIdentity());

            if (!requestDto.getTitle().equals(null))
                person.setTitle(requestDto.getTitle());
            if (!requestDto.getPersonName().equals(null))
                person.setPersonName(requestDto.getPersonName());
            if (!requestDto.getPrice().equals(null))
                person.setPrice(requestDto.getPrice());
            if (!requestDto.getUnit().equals(null))
                person.setUnit(requestDto.getUnit());
            if (!requestDto.getCompanyName().equals(null)) {
                Company company = companyRepository.findByCompanyName(requestDto.getCompanyName());
                person.setCompany(company);
            }
            personRepository.save(person);

            response.setMessage("Person updated");
        } else {
            throw new BusinessException("Ceheck Identity");

        }

        return response;

    }

    @Override
    public PersonResponse deletePerson(@Valid DeletePersonRequest requestDto) {
        PersonResponse response = new PersonResponse();
        if (!requestDto.getPersonIdentity().equals(null)) {
            Person person = personRepository.findByPersonIdentity(requestDto.getPersonIdentity());
            personRepository.delete(person);
            response.setMessage("Person Deleted");
        } else {
            throw new BusinessException("Check identity");
        }
        return response;

    }

}
