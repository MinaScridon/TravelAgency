package com.travel.travelAgency.service;


import com.travel.travelAgency.dto.TourDto;
import com.travel.travelAgency.entities.Tour;
import com.travel.travelAgency.exceptions.ResourceNotFoundException;
import com.travel.travelAgency.repository.TourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TourService {

    @Autowired
    private TourRepo tourRepo;

    @Autowired
    private TourMapper tourMapper;

    public List<TourDto> findAllTours() {
        return tourRepo.findAll().stream().map(tour -> tourMapper
                .convertToDto(tour)).collect(Collectors.toList());
    }

    public Optional<TourDto> findByIdTour(Long idTour) {
        Tour tour = (Tour) tourRepo.findTourByIdTour(idTour)
                .orElseThrow(() -> new ResourceNotFoundException("Tour with the id " + idTour + " not found"));
        return Optional.ofNullable(tourMapper.convertToDto(tour));
    }

    public TourDto createTour(TourDto tourDto) {
        Tour tour = tourMapper.convertToEntity(tourDto);
        tourRepo.save(tour);
        return tourMapper.convertToDto(tour);
    }

    public TourDto editTour(Long idTour, TourDto tourDto) {
        Tour tour = (Tour) tourRepo
                .findTourByIdTour(idTour)
                .orElseThrow(() -> new ResourceNotFoundException("Tour with the idTour " + idTour + " not found"));
        tour.setTourName(tourDto.getTourName());
        tour.setNumberOfDays(tourDto.getNumberOfDays());
        tour.setHotels(tourDto.getHotels());
        tour.setCities(tourDto.getCities());
        tour.setAirports(tourDto.getAirports());
        tour.setDepartureDate(tourDto.getDepartureDate());
        tour.setReturnDate(tourDto.getReturnDate());
        tour.setPriceForAChild(tourDto.getPriceForAChild());
        tour.setPriceForAnAdult(tourDto.getPriceForAnAdult());
        tour.setNumberOfChildSeats(tourDto.getNumberOfChildSeats());
        tour.setNumberOfAdultSeats(tourDto.getNumberOfAdultSeats());
        tour.setAvailability(tourDto.isAvailability());
        tour.setPromoted(tourDto.isPromoted());
        tourRepo.save(tour);
        return tourMapper.convertToDto(tour);
    }

    public void deleteTour(String tourName) {
        Tour tour = (Tour) tourRepo
                .findTourByTourName(tourName)
                .orElseThrow(() -> new ResourceNotFoundException("Tour with the tourName " + tourName + " not found"));
        tourRepo.delete(tour);
    }
}
