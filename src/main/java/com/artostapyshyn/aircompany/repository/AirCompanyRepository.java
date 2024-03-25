package com.artostapyshyn.aircompany.repository;

import com.artostapyshyn.aircompany.model.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
}
