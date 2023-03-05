package com.travel.travelAgency.controller;

import com.travel.travelAgency.dto.ContinentDto;
import com.travel.travelAgency.service.ContinentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ContinentController {
    private final ContinentService continentService;

    @GetMapping("/continents")
    public ResponseEntity<List<ContinentDto>> findAllTheContinents (){
        List<ContinentDto> allContinents = continentService.findAllContinents();
        return new ResponseEntity<>(allContinents, HttpStatus.OK);
    }

    @GetMapping("/continents/{idContinent}")
    public ResponseEntity<ContinentDto> findByIdContinent(@PathVariable Long idContinent){
        ContinentDto continentDto = continentService.findById(idContinent).get();
        return new ResponseEntity<>(continentDto, HttpStatus.OK);
    }

    @PostMapping("/createContinent")
    public ResponseEntity<ContinentDto> createContinent(@RequestBody ContinentDto continentDto){
        ContinentDto continentDto1 = continentService.createContinent(continentDto);
        return new ResponseEntity<>(continentDto1, HttpStatus.OK);
    }

    @PutMapping("/editContinent/{idContinent}")
    public ResponseEntity<ContinentDto> editContinent(@PathVariable Long idContinent, @RequestBody ContinentDto continentDto){
        ContinentDto continentDto1 = continentService.editContinent(idContinent, continentDto);

        return new ResponseEntity<>(continentDto1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteContinent/{continentName}")
    public ResponseEntity<?> deleteContinent(@PathVariable String continentName){
        continentService.deleteContinent(continentName);
        return new ResponseEntity<>("The continent with name " + continentName + " has been deleted successfully.", HttpStatus.OK);
    }
}
