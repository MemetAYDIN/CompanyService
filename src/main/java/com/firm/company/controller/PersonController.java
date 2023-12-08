package com.firm.company.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firm.company.dto.PersonDto.DeletePersonRequest;
import com.firm.company.dto.PersonDto.NewPersonRequestDto;
import com.firm.company.dto.PersonDto.PersonListResponse;
import com.firm.company.dto.PersonDto.PersonResponse;
import com.firm.company.dto.PersonDto.PersonUpdateRequestDto;
import com.firm.company.service.personservice.PersonService;

@RestController
@RequestMapping("api/v1/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/personlist")
    public ResponseEntity<List<PersonListResponse>> getAllPersons() {
        return ResponseEntity.ok().body(personService.getCompanyList());
    }

    @PostMapping(value = "/newperson")
    public ResponseEntity<PersonResponse> addNewPerson(@RequestBody NewPersonRequestDto requestDto) {
        return ResponseEntity.ok().body(personService.addNewPerson(requestDto));
    }

    @PutMapping(value = "/updateperson")
    public ResponseEntity<PersonResponse> updatePerson(@RequestBody PersonUpdateRequestDto requestDto) {
        return ResponseEntity.ok().body(personService.updatePerson(requestDto));
    }

    @DeleteMapping(value = "/deleteperson")
    public ResponseEntity<PersonResponse> deletePerson(@RequestBody DeletePersonRequest requestDto) {
        return ResponseEntity.ok().body(personService.deletePerson(requestDto));
    }

}
