package com.artostapyshyn.aircompany.controller;

import com.artostapyshyn.aircompany.dto.AirCompanyDto;
import com.artostapyshyn.aircompany.service.AirCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/aircompanies")
@AllArgsConstructor
public class AirCompanyController {

    private final AirCompanyService airCompanyService;

    @PostMapping
    public ResponseEntity<AirCompanyDto> createAirCompany(@RequestBody AirCompanyDto airCompanyDto) {
        AirCompanyDto savedAirCompanyDto = airCompanyService.save(airCompanyDto);
        return new ResponseEntity<>(savedAirCompanyDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AirCompanyDto>> getAllAirCompanies() {
        List<AirCompanyDto> airCompanies = airCompanyService.findAll();
        return ResponseEntity.ok(airCompanies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirCompanyDto> getAirCompanyById(@PathVariable Long id) {
        AirCompanyDto airCompanyDto = airCompanyService.mapToDto(airCompanyService.findById(id));
        return ResponseEntity.ok(airCompanyDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirCompanyDto> updateAirCompany(@PathVariable Long id, @RequestBody AirCompanyDto airCompanyDto) {
        airCompanyDto.setId(id);
        AirCompanyDto updatedAirCompany = airCompanyService.update(airCompanyDto);
        return ResponseEntity.ok(updatedAirCompany);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirCompany(@PathVariable Long id) {
        airCompanyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
