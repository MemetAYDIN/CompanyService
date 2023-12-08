package com.firm.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firm.company.entity.Company;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByCompanyName(String compnayName);

    Company findByCompanyId(Long companyId);
}
