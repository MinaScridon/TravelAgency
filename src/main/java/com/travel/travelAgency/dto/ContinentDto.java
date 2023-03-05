package com.travel.travelAgency.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class ContinentDto {

    private Long idContinent;

    @NotEmpty
    private String continentName;
}
