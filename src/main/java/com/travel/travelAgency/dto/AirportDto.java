package com.travel.travelAgency.dto;

import com.travel.travelAgency.entities.City;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AirportDto {


    private Long idAirport;

    @NotEmpty
    private String airportName;

    @NotEmpty
    private City city;
}
