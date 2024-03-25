package com.artostapyshyn.aircompany.service.impl;

import com.artostapyshyn.aircompany.exception.ResourceNotFoundException;
import com.artostapyshyn.aircompany.model.AirCompany;
import com.artostapyshyn.aircompany.model.Airplane;
import com.artostapyshyn.aircompany.repository.AirCompanyRepository;
import com.artostapyshyn.aircompany.repository.AirplaneRepository;
import com.artostapyshyn.aircompany.service.AirplaneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneRepository airplaneRepository;
    private final AirCompanyRepository airCompanyRepository;

    @Override
    @Transactional
    public void reassignAirplaneToCompany(AirCompany airCompany, Long airplaneId) {
        airplaneRepository.reassignAirplaneToCompany(airCompany, airplaneId);
    }

    @Override
    public Airplane addAirplane(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Airplane assignAirplaneToCompany(Long airplaneId, Long companyId) {
        Airplane airplane = airplaneRepository.findById(airplaneId)
                .orElseThrow(() -> new ResourceNotFoundException("Airplane not found"));

        AirCompany company = airCompanyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found"));

        airplane.setAirCompany(company);
        return airplaneRepository.save(airplane);
    }
}
