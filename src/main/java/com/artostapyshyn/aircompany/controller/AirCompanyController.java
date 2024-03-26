package com.artostapyshyn.aircompany.controller;

import com.artostapyshyn.aircompany.model.AirCompany;
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
    public ResponseEntity<AirCompany> createAirCompany(@RequestBody AirCompany airCompany) {
        AirCompany savedAirCompany = airCompanyService.save(airCompany);
        return new ResponseEntity<>(savedAirCompany, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AirCompany>> getAllAirCompanies() {
        List<AirCompany> airCompanies = airCompanyService.findAll();
        return ResponseEntity.ok(airCompanies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirCompany> getAirCompanyById(@PathVariable Long id) {
        AirCompany airCompanyOptional = airCompanyService.findById(id);
        return ResponseEntity.ok(airCompanyOptional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirCompany> updateAirCompany(@PathVariable Long id, @RequestBody AirCompany airCompany) {
        AirCompany updatedAirCompany = airCompanyService.update(airCompany);
        return ResponseEntity.ok(updatedAirCompany);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirCompany(@PathVariable Long id) {
        airCompanyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
