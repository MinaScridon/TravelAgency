package com.travel.travelAgency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHotel;

    private String hotelName;

    private int numberOfStars;

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<City>designatedCity;
}
