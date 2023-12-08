package com.firm.company.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "KISI")
@Data
public class Person implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "KISI_ID")
    private Long personId;

    @Column(name = "KIMLIK_NO", nullable = false, unique = true)
    private Long personIdentity;

    @Column(name = "KISI_AD", nullable = false)
    private String personName;

    @Column(name = "GOREV", nullable = false)
    private String title;

    @Column(name = "BIRIM", nullable = false)
    private String unit;

    @Column(name = "MAAS", nullable = false)
    private BigDecimal price;

    @CreatedDate
    @Column(updatable = false, nullable = true)
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(nullable = true)
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "SIRKET_ID")
    private Company company;

}
