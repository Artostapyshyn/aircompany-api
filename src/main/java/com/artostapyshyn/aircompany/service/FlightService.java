package com.artostapyshyn.aircompany.service;

import com.artostapyshyn.aircompany.dto.FlightDto;
import com.artostapyshyn.aircompany.enums.FlightStatus;

import java.util.List;

public interface FlightService {
    List<FlightDto> findByAirCompanyNameAndFlightStatus(String companyName, FlightStatus flightStatus);

    FlightDto addFlight(FlightDto flightDto);

    FlightDto changeFlightStatus(Long flightId, FlightStatus newStatus);

    List<FlightDto> findCompletedFlightsWithExceededEstimatedTime();
}
