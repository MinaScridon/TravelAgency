package com.travel.travelAgency.dto;

import com.travel.travelAgency.entities.Airport;
import com.travel.travelAgency.entities.City;
import com.travel.travelAgency.entities.Hotel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
public class TourDto {

    private Long idTour;

    @NotEmpty
    private String tourName;

    @NotEmpty
    private LocalDate departureDate;

    @NotEmpty
    private LocalDate returnDate;

    @NotEmpty
    private double priceForAnAdult;

    @NotEmpty
    private double priceForAChild;

    @NotEmpty
    private boolean promoted;

    @NotEmpty
    private int numberOfDays;

    @NotEmpty
    private int numberOfAdultSeats;

    @NotEmpty
    private int numberOfChildSeats;

    @NotEmpty
    private boolean availability;

    @NotEmpty
    private List<Airport> airports;

    @NotEmpty
    private List<City> cities;

    @NotEmpty
    private List<Hotel> hotels;
}
