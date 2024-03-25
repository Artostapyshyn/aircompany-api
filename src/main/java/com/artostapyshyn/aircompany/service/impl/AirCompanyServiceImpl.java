package com.artostapyshyn.aircompany.service.impl;

import com.artostapyshyn.aircompany.exception.ResourceNotFoundException;
import com.artostapyshyn.aircompany.model.AirCompany;
import com.artostapyshyn.aircompany.repository.AirCompanyRepository;
import com.artostapyshyn.aircompany.service.AirCompanyService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AirCompanyServiceImpl implements AirCompanyService {

    private final AirCompanyRepository airCompanyRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public AirCompany save(AirCompany airCompany) {
        return airCompanyRepository.save(airCompany);
    }

    @Override
    @Transactional(readOnly = true)
    public AirCompany findById(Long id) {
        return airCompanyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AirCompany not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AirCompany> findAll() {
        return airCompanyRepository.findAll();
    }

    @Override
    @Transactional
    public AirCompany update(AirCompany updateAirCompany) {
        Long airCompanyId = updateAirCompany.getId();

        AirCompany existingAirCompany = airCompanyRepository.findById(airCompanyId)
                .orElseThrow(() -> new ResourceNotFoundException("AirCompany not found"));
        modelMapper.map(updateAirCompany, existingAirCompany);
        return airCompanyRepository.save(updateAirCompany);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Optional<AirCompany> existingAirCompany = airCompanyRepository.findById(id);

        if (existingAirCompany.isEmpty()) {
            throw new ResourceNotFoundException("AirCompany not found with id: " + id);
        }

        airCompanyRepository.deleteById(id);
    }
}
