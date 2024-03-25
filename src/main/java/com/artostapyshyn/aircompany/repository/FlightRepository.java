package com.artostapyshyn.aircompany.repository;

import com.artostapyshyn.aircompany.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
