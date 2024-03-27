package com.artostapyshyn.aircompany.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AirCompanyDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String companyType;

    private LocalDate foundedAt;
    private List<Long> airplaneIds;
}