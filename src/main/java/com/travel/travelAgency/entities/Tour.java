package com.travel.travelAgency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tour")

public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long idTour;

    private String tourName;

    private LocalDate departureDate;

    private LocalDate returnDate;

    private double priceForAnAdult;

    private double priceForAChild;

    private boolean promoted;

    private int numberOfDays;

    private int numberOfAdultSeats;

    private int numberOfChildSeats;

    private boolean availability;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Airport> airports;

    @OneToMany(cascade = CascadeType.ALL)
    private List<City> cities;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Hotel> hotels;
}
