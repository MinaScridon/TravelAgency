package com.travel.travelAgency.service;

import com.travel.travelAgency.dto.AirportDto;
import com.travel.travelAgency.entities.Airport;
import com.travel.travelAgency.mapper.Mapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class AirportMapper implements Mapper<Airport, AirportDto> {

    public List<AirportDto> listConvertToDto(List<Airport> entity){
        List<AirportDto> result= new ArrayList<>();
        for (Airport airport:entity) {
            AirportDto airportDto = convertToDto(airport);
            result.add(airportDto);
        }
        return result;
    }
    public List<Airport> listConvertToEntity(List<AirportDto> dto){
        List<Airport> result= new ArrayList<>();
        for (AirportDto airport1:dto) {
            Airport airportEntity = convertToEntity(airport1);
            result.add(airportEntity);
        }
        return result;
    }

    @Override
    public AirportDto convertToDto(Airport entity) {
        AirportDto airportDto = new AirportDto();
        airportDto.setIdAirport(entity.getIdAirport());
        airportDto.setAirportName(entity.getAirportName());
        airportDto.setCity(entity.getCity());

        return airportDto;
    }

    @Override
    public Airport convertToEntity(AirportDto dto) {
        Airport airport = new Airport();
        airport.setIdAirport(dto.getIdAirport());
        airport.setAirportName(dto.getAirportName());
        airport.setCity(dto.getCity());
        return airport;
    }
}
