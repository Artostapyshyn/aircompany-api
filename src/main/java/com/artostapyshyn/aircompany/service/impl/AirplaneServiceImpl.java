package com.artostapyshyn.aircompany.service.impl;

import com.artostapyshyn.aircompany.dto.AirplaneDto;
import com.artostapyshyn.aircompany.exception.ResourceNotFoundException;
import com.artostapyshyn.aircompany.model.AirCompany;
import com.artostapyshyn.aircompany.model.Airplane;
import com.artostapyshyn.aircompany.repository.AirCompanyRepository;
import com.artostapyshyn.aircompany.repository.AirplaneRepository;
import com.artostapyshyn.aircompany.service.AirplaneService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneRepository airplaneRepository;
    private final AirCompanyRepository airCompanyRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void reassignAirplaneToCompany(Long airCompanyId, Long airplaneId) {
        AirCompany airCompany = airCompanyRepository.findById(airCompanyId)
                .orElseThrow(() -> new ResourceNotFoundException("AirCompany not found"));

        airplaneRepository.reassignAirplaneToCompany(airCompany, airplaneId);
    }

    @Override
    public AirplaneDto addAirplane(AirplaneDto airplaneDto) {
        Airplane airplane = modelMapper.map(airplaneDto, Airplane.class);
        return modelMapper.map(airplaneRepository.save(airplane), AirplaneDto.class);
    }

    @Override
    public AirplaneDto assignAirplaneToCompany(Long airplaneId, Long companyId) {
        Airplane airplane = airplaneRepository.findById(airplaneId)
                .orElseThrow(() -> new ResourceNotFoundException("Airplane not found"));

        AirCompany company = airCompanyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found"));

        airplane.setAirCompany(company);
        return modelMapper.map(airplaneRepository.save(airplane), AirplaneDto.class);
    }
}
