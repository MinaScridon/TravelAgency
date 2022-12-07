package com.travel.travelAgency.service;

import com.travel.travelAgency.dto.CityDto;
import com.travel.travelAgency.entities.City;
import com.travel.travelAgency.exceptions.ResourceNotFoundException;
import com.travel.travelAgency.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private CityMapper cityMapper;

    public List<CityDto> findAllCities() {
        return cityRepo.findAll().stream().map(city -> cityMapper
                .convertToDto(city)).collect(Collectors.toList());
    }

    public Optional<CityDto> findById(Long idCity) {
        City city = cityRepo.findByIdCity(idCity)
                .orElseThrow(() -> new ResourceNotFoundException("City with the id " + idCity + " not found"));
        return Optional.ofNullable(cityMapper.convertToDto(city));
    }

    public CityDto createCity(CityDto cityDto) {
        City city = cityMapper.convertToEntity(cityDto);
        cityRepo.save(city);
        return cityMapper.convertToDto(city);
    }

    public CityDto editCity(Long idCity, CityDto cityDto) {
        City city = cityRepo
                .findByIdCity(idCity)
                .orElseThrow(() -> new ResourceNotFoundException("City with the id " + idCity + " not found"));
        city.setCityName(cityDto.getCityName());
        city.setCountry(cityDto.getCountry());
        cityRepo.save(city);

        return cityMapper.convertToDto(city);
    }

    public void deleteCity(String name){
        City city = (City) cityRepo
                .findByCityName(name)
                .orElseThrow(()->new ResourceNotFoundException("City with the name " + name + " not found"));
        cityRepo.delete(city);
    }
}
