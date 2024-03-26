package com.artostapyshyn.aircompany.controller;

import com.artostapyshyn.aircompany.model.AirCompany;
import com.artostapyshyn.aircompany.model.Airplane;
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

    @PutMapping("/{id}/reassign")
    public ResponseEntity<Void> reassignAirplaneToCompany(@PathVariable Long id, @RequestBody AirCompany airCompany) {
        airplaneService.reassignAirplaneToCompany(airCompany, id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Airplane> addAirplane(@RequestBody Airplane airplane) {
        Airplane newAirplane = airplaneService.addAirplane(airplane);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAirplane);
    }

    @PostMapping("/{airplaneId}/assign/{companyId}")
    public ResponseEntity<Airplane> assignAirplaneToCompany(
            @PathVariable Long airplaneId,
            @PathVariable Long companyId
    ) {
        Airplane assignedAirplane = airplaneService.assignAirplaneToCompany(airplaneId, companyId);
        return ResponseEntity.ok(assignedAirplane);
    }

}

