package com.artostapyshyn.aircompany.controller;

import com.artostapyshyn.aircompany.enums.FlightStatus;
import com.artostapyshyn.aircompany.model.Flight;
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
    public ResponseEntity<List<Flight>> findCompletedFlightsWithExceededEstimatedTime() {
        List<Flight> flights = flightService.findCompletedFlightsWithExceededEstimatedTime();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/company/{companyName}/status/{status}")
    public ResponseEntity<List<Flight>> findFlightsByCompanyAndStatus(@PathVariable String companyName,
                                                                      @PathVariable FlightStatus status) {
        List<Flight> flights = flightService.findByAirCompanyNameAndFlightStatus(companyName, status);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/active/started-more-than-24-hours-ago")
    public ResponseEntity<List<Flight>> findActiveFlightsStartedMoreThan24HoursAgo() {
        List<Flight> flights = flightService.findByFlightStatusAndStartedAtBefore();
        return ResponseEntity.ok(flights);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Flight> changeFlightStatus(@PathVariable Long id, @RequestParam FlightStatus newStatus) {
        Flight updatedFlight = flightService.changeFlightStatus(id, newStatus);
        return ResponseEntity.ok(updatedFlight);
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight newFlight = flightService.addFlight(flight);
        return ResponseEntity.ok(newFlight);
    }
}
