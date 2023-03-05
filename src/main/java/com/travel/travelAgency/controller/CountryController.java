package com.travel.travelAgency.controller;


import com.travel.travelAgency.dto.CountryDto;
import com.travel.travelAgency.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<List<CountryDto>> findAllTheCountries (){
        List<CountryDto> allCountries = countryService.findAllCountries();
        return new ResponseEntity<>(allCountries, HttpStatus.OK);
    }

    @GetMapping("/countries/{idCountry}")
    public ResponseEntity<CountryDto> findByIdCountry(@PathVariable Long idCountry){
        CountryDto countryDto = countryService.findById(idCountry).get();
        return new ResponseEntity<>(countryDto, HttpStatus.OK);
    }

    @PostMapping("/createCountry")
    public ResponseEntity<CountryDto> createCountry(@RequestBody CountryDto countryDto){
        CountryDto countryDto1 = countryService.createCountry(countryDto);
        return new ResponseEntity<>(countryDto1, HttpStatus.OK);
    }

    @PutMapping("/editCountry/{idCountry}")
    public ResponseEntity<CountryDto> editCountry(@RequestBody CountryDto countryDto , @PathVariable Long idCountry){
        CountryDto countryDto1 = countryService.editCountry(idCountry,countryDto);

        return new ResponseEntity<>(countryDto1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCountry/{countryName}")
    public ResponseEntity<?> deleteCountry(@PathVariable String countryName){
        countryService.deleteCountry(countryName);
        return new ResponseEntity<>("The country with name " + countryName + " has been deleted successfully.", HttpStatus.OK);
    }
}
