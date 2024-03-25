package com.artostapyshyn.aircompany.repository;

import com.artostapyshyn.aircompany.enums.FlightStatus;
import com.artostapyshyn.aircompany.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByFlightStatus(FlightStatus flightStatus);

    List<Flight> findByAirCompanyNameAndFlightStatus(String companyName, FlightStatus flightStatus);

    List<Flight> findByFlightStatusAndStartedAtBefore(FlightStatus flightStatus, LocalDateTime startedAt);
}
