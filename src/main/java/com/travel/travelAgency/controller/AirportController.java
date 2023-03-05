package com.travel.travelAgency.controller;

import com.travel.travelAgency.dto.AirportDto;
import com.travel.travelAgency.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

    @GetMapping("/airports")
    public ResponseEntity<List<AirportDto>> findAllTheAirports() {
        List<AirportDto> allAirports = airportService.findAllAirports();
        return new ResponseEntity<>(allAirports, HttpStatus.OK);
    }

    @GetMapping("/airports/{idAirport}")
    public ResponseEntity<AirportDto> findByIdAirport(@PathVariable Long idAirport) {
        AirportDto airportDto = airportService.findById(idAirport).get();
        return new ResponseEntity<>(airportDto, HttpStatus.OK);
    }

    @PostMapping("/createAirport")
    public ResponseEntity<AirportDto> createAirport(@RequestBody AirportDto airportDto) {
        AirportDto airportDto1 = airportService.createAirport(airportDto);

        return new ResponseEntity<>(airportDto1, HttpStatus.OK);
    }

    @PutMapping("/editAirport/{idAirport}")
    public ResponseEntity<AirportDto> editAirport(@RequestBody AirportDto airportDto, @PathVariable Long idAirport) {
        AirportDto airportDto1 = airportService.editAirport(idAirport, airportDto);

        return new ResponseEntity<>(airportDto1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAirport/{airportName}")
    public ResponseEntity<?> deleteAirport(@PathVariable String airportName) {
        airportService.deleteAirport(airportName);
        return new ResponseEntity<>("The airport with name " + airportName + " has been deleted successfully.", HttpStatus.OK);
    }
}
