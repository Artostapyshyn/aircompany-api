package com.artostapyshyn.aircompany.dto;

import com.artostapyshyn.aircompany.enums.FlightStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class FlightDto {

    private Long id;
    private FlightStatus flightStatus;
    private Long airCompanyId;
    private Long airplaneId;

    @NotBlank
    private String departureCountry;

    @NotBlank
    private String destinationCountry;

    @Min(value = 0)
    private Double distance;

    @Min(value = 0)
    private Integer estimatedFlightTime;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private LocalDateTime delayStartedAt;
    private LocalDateTime createdAt;
}
