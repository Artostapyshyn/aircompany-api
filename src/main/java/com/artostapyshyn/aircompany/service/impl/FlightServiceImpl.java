package com.artostapyshyn.aircompany.service.impl;

import com.artostapyshyn.aircompany.dto.FlightDto;
import com.artostapyshyn.aircompany.enums.FlightStatus;
import com.artostapyshyn.aircompany.exception.ResourceNotFoundException;
import com.artostapyshyn.aircompany.model.Flight;
import com.artostapyshyn.aircompany.repository.FlightRepository;
import com.artostapyshyn.aircompany.service.FlightService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<FlightDto> findByAirCompanyNameAndFlightStatus(String companyName, FlightStatus flightStatus) {
        List<Flight> flights = flightRepository.findByAirCompanyNameAndFlightStatus(companyName, flightStatus);
        return flights.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public FlightDto addFlight(FlightDto flightDto) {
        Flight flight = modelMapper.map(flightDto, Flight.class);
        flight.setFlightStatus(FlightStatus.PENDING);
        Flight savedFlight = flightRepository.save(flight);
        return mapToDto(savedFlight);
    }

    @Override
    public FlightDto changeFlightStatus(Long flightId, FlightStatus newStatus) {
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
        Flight updatedFlight = flightRepository.save(flight);
        return mapToDto(updatedFlight);
    }

    @Override
    public List<FlightDto> findCompletedFlightsWithExceededEstimatedTime() {
        List<Flight> completedFlights = flightRepository.findByFlightStatus(FlightStatus.COMPLETED);

        return completedFlights.stream()
                .filter(flight -> {
                    long durationInMinutes = Duration.between(flight.getStartedAt(), flight.getEndedAt()).toMinutes();
                    return durationInMinutes > flight.getEstimatedFlightTime();
                })
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private FlightDto mapToDto(Flight flight) {
        return modelMapper.map(flight, FlightDto.class);
    }
}
