package com.firm.company.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SIRKET")
@Data
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "SIRKET_ID")
    private Long companyId;

    @Column(name = "SIRKET_AD", nullable = false, unique = true)
    private String companyName;

    @CreatedDate
    @Column(updatable = false, nullable = true)
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(nullable = true)
    private LocalDate updatedAt;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private List<Person> personList;
}
