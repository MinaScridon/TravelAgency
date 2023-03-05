package com.travel.travelAgency.service;

import com.travel.travelAgency.dto.PurchasingATourDto;
import com.travel.travelAgency.entities.PurchasingATour;
import com.travel.travelAgency.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PurchasingATourMapper implements Mapper<PurchasingATour, PurchasingATourDto> {


    public List<PurchasingATourDto> listConvertToDto(List<PurchasingATour> entity){
        List<PurchasingATourDto> result= new ArrayList<>();
        for (PurchasingATour purchasingATour:entity) {
            PurchasingATourDto purchasingATourDto = convertToDto(purchasingATour);
            result.add(purchasingATourDto);
        }
        return result;
    }

    public List<PurchasingATour> listConvertToEntity(List<PurchasingATourDto> dto){
        List<PurchasingATour> result= new ArrayList<>();
        for (PurchasingATourDto purchasingATourDto:dto) {
            PurchasingATour purchasingATourEntity = convertToEntity(purchasingATourDto);
            result.add(purchasingATourEntity);
        }
        return result;
    }

    @Override
    public PurchasingATourDto convertToDto(PurchasingATour entity) {
        PurchasingATourDto purchasingATourDto = new PurchasingATourDto();
        purchasingATourDto.setIdPurchasingATour(entity.getIdPurchasingATour());
        purchasingATourDto.setTours(entity.getTours());
        purchasingATourDto.setAmount(entity.getAmount());
        purchasingATourDto.setNumberOfParticipants(entity.getNumberOfParticipants());
        return purchasingATourDto;
    }

    @Override
    public PurchasingATour convertToEntity(PurchasingATourDto dto) {
        PurchasingATour purchasingATour = new PurchasingATour();
        purchasingATour.setIdPurchasingATour(dto.getIdPurchasingATour());
        purchasingATour.setTours(dto.getTours());
        purchasingATour.setAmount(dto.getAmount());
        purchasingATour.setNumberOfParticipants(dto.getNumberOfParticipants());
        return purchasingATour;
    }
}
