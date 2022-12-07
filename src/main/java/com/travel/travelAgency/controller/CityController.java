package com.travel.travelAgency.controller;

import com.travel.travelAgency.dto.CityDto;
import com.travel.travelAgency.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;
    @GetMapping("/cities")
    public ResponseEntity<List<CityDto>> findAllTheCities (){
        List<CityDto> allCities = cityService.findAllCities();
        return new ResponseEntity<>(allCities, HttpStatus.OK);
    }

    @GetMapping("/cities/{idCity}")
    public ResponseEntity<CityDto> findByIdCity(@PathVariable Long idCity){
        CityDto cityDto = cityService.findById(idCity).get();
        return new ResponseEntity<>(cityDto, HttpStatus.OK);
    }

    @PostMapping("/createCity")
    public ResponseEntity<CityDto> createCity(@RequestBody CityDto cityDto){
        CityDto cityDto1 = cityService.createCity(cityDto);
        return new ResponseEntity<>(cityDto1, HttpStatus.OK);
    }

    @PutMapping("/editCity/{idCity}")
    public ResponseEntity<CityDto> editCity(@RequestBody CityDto cityDto , @PathVariable Long idCity){
        CityDto cityDto1 = cityService.editCity(idCity,cityDto);
        return new ResponseEntity<>(cityDto1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCity/{cityName}")
    public ResponseEntity<?> deleteCity(@PathVariable String cityName){
        cityService.deleteCity(cityName);
        return new ResponseEntity<>("The city with name " + cityName + " has been deleted successfully.", HttpStatus.OK);
    }
}
