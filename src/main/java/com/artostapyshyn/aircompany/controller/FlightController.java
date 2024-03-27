package com.artostapyshyn.aircompany.controller;

import com.artostapyshyn.aircompany.dto.FlightDto;
import com.artostapyshyn.aircompany.enums.FlightStatus;
import com.artostapyshyn.aircompany.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
@AllArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/completed/exceeded-estimated-time")
    public ResponseEntity<List<FlightDto>> findCompletedFlightsWithExceededEstimatedTime() {
        List<FlightDto> flights = flightService.findCompletedFlightsWithExceededEstimatedTime();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/company/{companyName}/status/{status}")
    public ResponseEntity<List<FlightDto>> findFlightsByCompanyAndStatus(@PathVariable String companyName,
                                                                         @PathVariable FlightStatus status) {
        List<FlightDto> flights = flightService.findByAirCompanyNameAndFlightStatus(companyName, status);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/active/started-more-than-24-hours-ago")
    public ResponseEntity<List<FlightDto>> findActiveFlightsStartedMoreThan24HoursAgo() {
        List<FlightDto> flights = flightService.findCompletedFlightsWithExceededEstimatedTime();
        return ResponseEntity.ok(flights);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<FlightDto> changeFlightStatus(@PathVariable Long id, @RequestParam FlightStatus newStatus) {
        FlightDto updatedFlight = flightService.changeFlightStatus(id, newStatus);
        return ResponseEntity.ok(updatedFlight);
    }

    @PostMapping
    public ResponseEntity<FlightDto> addFlight(@RequestBody FlightDto flightDto) {
        FlightDto newFlight = flightService.addFlight(flightDto);
        return ResponseEntity.ok(newFlight);
    }
}