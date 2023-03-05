package com.travel.travelAgency.controller;

import com.travel.travelAgency.dto.TourDto;
import com.travel.travelAgency.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TourController {
    private final TourService tourService;

    @GetMapping("/tours")
    public ResponseEntity<List<TourDto>> findAllTheTours (){
        List<TourDto> allTours = tourService.findAllTours();
        return new ResponseEntity<>(allTours, HttpStatus.OK);
    }

    @GetMapping("/tours/{idTour}")
    public ResponseEntity<TourDto> findByIdTour(@PathVariable Long idTour){
        TourDto tourDto = tourService.findByIdTour(idTour).get();
        return new ResponseEntity<>(tourDto, HttpStatus.OK);
    }

    @PostMapping("/createTour")
    public ResponseEntity<TourDto> createTour(@RequestBody TourDto tourDto){
        TourDto tourDto1 = tourService.createTour(tourDto);
        return new ResponseEntity<>(tourDto1, HttpStatus.OK);
    }

    @PutMapping("/editTour/{idTour}")
    public ResponseEntity<TourDto> editTour(@RequestBody TourDto tourDto , @PathVariable Long idTour){
        TourDto tourDto1 = tourService.editTour(idTour,tourDto);

        return new ResponseEntity<>(tourDto1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTour/{tourName}")
    public ResponseEntity<?> deleteTour(@PathVariable String tourName){
        tourService.deleteTour(tourName);
        return new ResponseEntity<>("The tour with id " + tourName + " has been deleted successfully.", HttpStatus.OK);
    }
}
