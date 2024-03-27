package com.artostapyshyn.aircompany.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class AirplaneDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String factorySerialNumber;

    private Long airCompanyId;

    @Min(value = 0)
    private Integer numberOfFlights;

    @Min(value = 0)
    private Double flightDistance;

    @Min(value = 0)
    private Double fuelCapacity;

    @NotBlank
    private String type;

    private LocalDateTime createdAt;
}

