package com.travel.travelAgency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContinent;

    @Column(unique = true)
    private String continentName;

}
