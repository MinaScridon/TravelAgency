package com.travel.travelAgency.dto;


import com.travel.travelAgency.entities.City;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class HotelDto {

    private Long idHotel;

    @NotEmpty
    private String hotelName;

    @NotEmpty
    private int numberOfStars;

    @NotEmpty
    private String description;

    @NotEmpty
    private List<City> designatedCity;
}
