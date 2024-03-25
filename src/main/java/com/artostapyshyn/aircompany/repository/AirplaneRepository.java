package com.artostapyshyn.aircompany.repository;

import com.artostapyshyn.aircompany.model.AirCompany;
import com.artostapyshyn.aircompany.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    @Modifying
    @Query("UPDATE Airplane a SET a.airCompany = :airCompany WHERE a.id = :airplaneId")
    void reassignAirplaneToCompany(@Param("airCompany") AirCompany airCompany, @Param("airplaneId") Long airplaneId);
}
