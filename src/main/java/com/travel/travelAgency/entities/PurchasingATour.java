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
@Table(name = "PurchasingATour")

public class PurchasingATour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPurchasingATour;

    private int numberOfParticipants;

    private double amount;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tour> tours;

}
