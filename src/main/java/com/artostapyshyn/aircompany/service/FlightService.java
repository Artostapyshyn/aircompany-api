package com.artostapyshyn.aircompany.service;

import com.artostapyshyn.aircompany.enums.FlightStatus;
import com.artostapyshyn.aircompany.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> findByAirCompanyNameAndFlightStatus(String companyName, FlightStatus flightStatus);

    List<Flight> findByFlightStatusAndStartedAtBefore();

    Flight addFlight(Flight flight);

    Flight changeFlightStatus(Long flightId, FlightStatus newStatus);

    List<Flight> findCompletedFlightsWithExceededEstimatedTime();
}
