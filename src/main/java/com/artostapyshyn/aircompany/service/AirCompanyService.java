package com.artostapyshyn.aircompany.service;

import com.artostapyshyn.aircompany.dto.AirCompanyDto;
import com.artostapyshyn.aircompany.model.AirCompany;

import java.util.List;

public interface AirCompanyService {
    AirCompanyDto save(AirCompanyDto airCompanyDto);

    AirCompany findById(Long id);

    List<AirCompanyDto> findAll();

    AirCompanyDto update(AirCompanyDto updateAirCompanyDto);

    void deleteById(Long id);

    AirCompanyDto mapToDto(AirCompany airCompany);
}
