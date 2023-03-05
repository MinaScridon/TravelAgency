package com.travel.travelAgency.service;

import com.travel.travelAgency.dto.TourDto;
import com.travel.travelAgency.entities.Tour;
import com.travel.travelAgency.mapper.Mapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class TourMapper implements Mapper<Tour, TourDto> {

    public List<TourDto> listConvertToDto(List<Tour> entity){
        List<TourDto> result= new ArrayList<>();
        for (Tour tour:entity) {
            TourDto tourDto = convertToDto(tour);
            result.add(tourDto);
        }
        return result;
    }
    public List<Tour> listConvertToEntity(List<TourDto> dto){
        List<Tour> result= new ArrayList<>();
        for (TourDto tourDto:dto) {
            Tour purchasingATourEntity = convertToEntity(tourDto);
            result.add(purchasingATourEntity);
        }
        return result;
    }

    @Override
    public TourDto convertToDto(Tour entity) {
        TourDto tourDto = new TourDto();
        tourDto.setIdTour(entity.getIdTour());
        tourDto.setTourName(entity.getTourName());
        tourDto.setAirports(entity.getAirports());
        tourDto.setCities(entity.getCities());
        tourDto.setHotels(entity.getHotels());
        tourDto.setPromoted(entity.isPromoted());
        tourDto.setDepartureDate(entity.getDepartureDate());
        tourDto.setReturnDate(entity.getReturnDate());
        tourDto.setNumberOfAdultSeats(entity.getNumberOfAdultSeats());
        tourDto.setNumberOfChildSeats(entity.getNumberOfChildSeats());
        tourDto.setPriceForAnAdult(entity.getPriceForAnAdult());
        tourDto.setPriceForAChild(entity.getPriceForAChild());
        tourDto.setNumberOfDays(entity.getNumberOfDays());
        tourDto.setAvailability(entity.isAvailability());
        return tourDto;
    }

    @Override
    public Tour convertToEntity(TourDto dto) {
        Tour tour = new Tour();
        tour.setIdTour(dto.getIdTour());
        tour.setTourName(dto.getTourName());
        tour.setAirports(dto.getAirports());
        tour.setCities(dto.getCities());
        tour.setHotels(dto.getHotels());
        tour.setPromoted(dto.isPromoted());
        tour.setDepartureDate(dto.getDepartureDate());
        tour.setReturnDate(dto.getReturnDate());
        tour.setNumberOfAdultSeats(dto.getNumberOfAdultSeats());
        tour.setNumberOfChildSeats(dto.getNumberOfChildSeats());
        tour.setPriceForAnAdult(dto.getPriceForAnAdult());
        tour.setPriceForAChild(dto.getPriceForAChild());
        tour.setNumberOfDays(dto.getNumberOfDays());
        tour.setAvailability(dto.isAvailability());
        return tour;
    }
}
