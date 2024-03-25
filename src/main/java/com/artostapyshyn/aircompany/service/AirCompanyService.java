package com.artostapyshyn.aircompany.service;

import com.artostapyshyn.aircompany.model.AirCompany;

import java.util.List;

public interface AirCompanyService {
    AirCompany save(AirCompany airCompany);

    AirCompany findById(Long id);

    List<AirCompany> findAll();

    AirCompany update(AirCompany airCompany);

    void deleteById(Long id);
}
