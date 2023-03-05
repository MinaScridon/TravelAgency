package com.travel.travelAgency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCountry;

    private String countryName;

    @OneToOne(cascade = CascadeType.ALL)
    private Continent continent;
}
