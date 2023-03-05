package com.travel.travelAgency.dto;

import com.travel.travelAgency.entities.Country;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CityDto {


    private Long idCity;

    @NotEmpty
    private String cityName;

    @NotEmpty
    private Country country;
}
