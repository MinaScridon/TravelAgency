package com.travel.travelAgency.service;

import com.travel.travelAgency.dto.AirportDto;
import com.travel.travelAgency.entities.Airport;
import com.travel.travelAgency.exceptions.ResourceNotFoundException;
import com.travel.travelAgency.repository.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AirportService {

    @Autowired
    private AirportRepo airportRepo;

    @Autowired
    private AirportMapper airportMapper;

    public List<AirportDto> findAllAirports() {
        return airportRepo.findAll().stream().map(airport -> airportMapper
                .convertToDto(airport)).collect(Collectors.toList());
    }

    public Optional<AirportDto> findById(Long idAirport) {
        Airport airport = airportRepo.findByIdAirport(idAirport)
                .orElseThrow(() -> new ResourceNotFoundException("Airport with the id " + idAirport + " not found"));
        return Optional.ofNullable(airportMapper.convertToDto(airport));
    }

    public AirportDto createAirport(AirportDto airportDto) {
        Airport airport = airportMapper.convertToEntity(airportDto);
        airportRepo.save(airport);
        return airportMapper.convertToDto(airport);
    }

    public AirportDto editAirport(Long idAirport, AirportDto airportDto) {
        Airport airport = airportRepo
                .findByIdAirport(idAirport)
                .orElseThrow(() -> new ResourceNotFoundException("Airport with the ID " + idAirport + " not found"));
        airport.setAirportName(airportDto.getAirportName());
        airport.setCity(airportDto.getCity());
        airportRepo.save(airport);

        return airportMapper.convertToDto(airport);
    }

    public void deleteAirport(String airportName){
        Airport airport = (Airport) airportRepo
                .findByAirportName(airportName)
                .orElseThrow(()->new ResourceNotFoundException("Airport with the name " + airportName + " not found"));
        airportRepo.delete(airport);
    }
}
