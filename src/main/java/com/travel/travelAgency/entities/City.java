package com.travel.travelAgency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCity;

    private String cityName;

    @OneToOne(cascade = CascadeType.ALL)
    private Country country;
}
