package com.artostapyshyn.aircompany.service;

import com.artostapyshyn.aircompany.model.AirCompany;
import com.artostapyshyn.aircompany.model.Airplane;

public interface AirplaneService {
    void reassignAirplaneToCompany(AirCompany airCompany, Long airplaneId);

    Airplane addAirplane(Airplane airplane);

    Airplane assignAirplaneToCompany(Long airplaneId, Long companyId);
}
