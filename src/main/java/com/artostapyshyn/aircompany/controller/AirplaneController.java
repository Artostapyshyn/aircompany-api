package com.artostapyshyn.aircompany.controller;

import com.artostapyshyn.aircompany.dto.AirplaneDto;
import com.artostapyshyn.aircompany.service.AirplaneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/airplanes")
@AllArgsConstructor
public class AirplaneController {

    private final AirplaneService airplaneService;

    @PutMapping("/{id}/reassign/{companyId}")
    public ResponseEntity<Void> reassignAirplaneToCompany(@PathVariable Long id, @PathVariable Long companyId) {
        airplaneService.reassignAirplaneToCompany(companyId, id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<AirplaneDto> addAirplane(@RequestBody AirplaneDto airplaneDto) {
        AirplaneDto newAirplane = airplaneService.addAirplane(airplaneDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAirplane);
    }

    @PostMapping("/{airplaneId}/assign/{companyId}")
    public ResponseEntity<AirplaneDto> assignAirplaneToCompany(
            @PathVariable Long airplaneId,
            @PathVariable Long companyId
    ) {
        AirplaneDto assignedAirplane = airplaneService.assignAirplaneToCompany(airplaneId, companyId);
        return ResponseEntity.ok(assignedAirplane);
    }
}

