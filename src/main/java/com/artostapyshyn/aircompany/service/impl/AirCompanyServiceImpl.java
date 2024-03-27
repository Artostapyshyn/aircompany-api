package com.artostapyshyn.aircompany.service.impl;

import com.artostapyshyn.aircompany.dto.AirCompanyDto;
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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AirCompanyServiceImpl implements AirCompanyService {

    private final AirCompanyRepository airCompanyRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public AirCompanyDto save(AirCompanyDto airCompanyDto) {
        AirCompany airCompany = modelMapper.map(airCompanyDto, AirCompany.class);
        AirCompany savedAirCompany = airCompanyRepository.save(airCompany);
        return modelMapper.map(savedAirCompany, AirCompanyDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public AirCompany findById(Long id) {
        return airCompanyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AirCompany not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AirCompanyDto> findAll() {
        return airCompanyRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AirCompanyDto update(AirCompanyDto updateAirCompanyDto) {
        AirCompany existingAirCompany = airCompanyRepository.findById(updateAirCompanyDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("AirCompany not found with id: " + updateAirCompanyDto.getId()));

        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(updateAirCompanyDto, existingAirCompany);
        AirCompany updatedAirCompany = airCompanyRepository.save(existingAirCompany);
        return modelMapper.map(updatedAirCompany, AirCompanyDto.class);
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

    public AirCompanyDto mapToDto(AirCompany airCompany) {
        return modelMapper.map(airCompany, AirCompanyDto.class);
    }
}
