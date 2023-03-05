package com.travel.travelAgency.dto;

import com.travel.travelAgency.entities.Continent;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CountryDto {

    private Long idCountry;

    @NotEmpty
    private String countryName;

   @NotEmpty
    private Continent continent;
}
