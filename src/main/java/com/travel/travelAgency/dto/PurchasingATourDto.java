package com.travel.travelAgency.dto;

import com.travel.travelAgency.entities.Tour;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class PurchasingATourDto {


    private Long idPurchasingATour;

    @NotEmpty
    private int numberOfParticipants;

    @NotEmpty
    private double amount;

    @NotEmpty
    private List<Tour> tours;
}
