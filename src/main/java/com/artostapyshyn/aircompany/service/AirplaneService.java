package com.artostapyshyn.aircompany.service;

import com.artostapyshyn.aircompany.dto.AirplaneDto;

public interface AirplaneService {

    void reassignAirplaneToCompany(Long airCompanyId, Long airplaneId);

    AirplaneDto addAirplane(AirplaneDto airplaneDto);

    AirplaneDto assignAirplaneToCompany(Long airplaneId, Long companyId);
}
