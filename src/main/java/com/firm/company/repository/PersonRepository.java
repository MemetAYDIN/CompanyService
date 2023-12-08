package com.firm.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firm.company.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByPersonIdentity(Long personIdentity);
}
