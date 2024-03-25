package com.artostapyshyn.aircompany.service.impl;

import com.artostapyshyn.aircompany.enums.FlightStatus;
import com.artostapyshyn.aircompany.exception.ResourceNotFoundException;
import com.artostapyshyn.aircompany.model.Flight;
import com.artostapyshyn.aircompany.repository.FlightRepository;
import com.artostapyshyn.aircompany.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public List<Flight> findByAirCompanyNameAndFlightStatus(String companyName, FlightStatus flightStatus) {
        return flightRepository.findByAirCompanyNameAndFlightStatus(companyName, flightStatus);
    }

    @Override
    public List<Flight> findByFlightStatusAndStartedAtBefore() {
        LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minusHours(24);
        return flightRepository.findByFlightStatusAndStartedAtBefore(FlightStatus.ACTIVE, twentyFourHoursAgo);
    }

    @Override
    public Flight addFlight(Flight flight) {
        flight.setFlightStatus(FlightStatus.PENDING);
        return flightRepository.save(flight);
    }

    @Override
    public Flight changeFlightStatus(Long flightId, FlightStatus newStatus) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + flightId));

        LocalDateTime now = LocalDateTime.now();

        switch (newStatus) {
            case DELAYED:
                flight.setDelayStartedAt(now);
                break;
            case ACTIVE:
                flight.setStartedAt(now);
                break;
            case COMPLETED:
                flight.setEndedAt(now);
                break;
            default:
                throw new IllegalArgumentException("Invalid flight status: " + newStatus);
        }

        flight.setFlightStatus(newStatus);
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> findCompletedFlightsWithExceededEstimatedTime() {
        List<Flight> completedFlights = flightRepository.findByFlightStatus(FlightStatus.COMPLETED);

        return completedFlights.stream()
                .filter(flight -> {
                    long durationInMinutes = Duration.between(flight.getStartedAt(), flight.getEndedAt()).toMinutes();
                    return durationInMinutes > flight.getEstimatedFlightTime();
                })
                .collect(Collectors.toList());
    }
}
