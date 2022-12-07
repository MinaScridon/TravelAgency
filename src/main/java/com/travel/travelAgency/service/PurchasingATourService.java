package com.travel.travelAgency.service;


import com.travel.travelAgency.dto.PurchasingATourDto;
import com.travel.travelAgency.entities.PurchasingATour;
import com.travel.travelAgency.exceptions.ResourceNotFoundException;
import com.travel.travelAgency.repository.PurchasingATourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchasingATourService {
    @Autowired
    private PurchasingATourRepo purchasingATourRepo;

    @Autowired
    private PurchasingATourMapper purchasingATourMapper;

    public List<PurchasingATourDto> findAllPurchases() {
        return purchasingATourRepo.findAll().stream().map(purchasingATour -> purchasingATourMapper
                .convertToDto(purchasingATour)).collect(Collectors.toList());
    }

    public Optional<PurchasingATourDto> findById(Long id) {
        PurchasingATour purchasingATour = purchasingATourRepo.findByIdPurchasingATour(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour with the name " + id + " not found"));
        return Optional.ofNullable(purchasingATourMapper.convertToDto(purchasingATour));
    }

    public PurchasingATourDto createPurchase(PurchasingATourDto purchasingATourDto) {
        PurchasingATour purchasingATour = purchasingATourMapper.convertToEntity(purchasingATourDto);
        purchasingATourRepo.save(purchasingATour);
        return purchasingATourMapper.convertToDto(purchasingATour);
    }

    public PurchasingATourDto editPurchase(Long id, PurchasingATourDto purchasingATourDto) {
        PurchasingATour purchasingATour = purchasingATourRepo
                .findByIdPurchasingATour(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour with the id " + id + " not found"));
        purchasingATour.setTours(purchasingATourDto.getTours());
        purchasingATour.setAmount(purchasingATourDto.getAmount());
        purchasingATour.setNumberOfParticipants(purchasingATourDto.getNumberOfParticipants());

        purchasingATourRepo.save(purchasingATour);
        return purchasingATourMapper.convertToDto(purchasingATour);
    }

    public void deletePurchase(Long id){
        PurchasingATour purchasingATour = purchasingATourRepo
                .findByIdPurchasingATour(id)
                .orElseThrow(()->new ResourceNotFoundException("Tour with the id " + id + " not found"));
        purchasingATourRepo.delete(purchasingATour);
    }


}

