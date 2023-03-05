package com.travel.travelAgency.service;

import com.travel.travelAgency.dto.CityDto;
import com.travel.travelAgency.entities.City;
import com.travel.travelAgency.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityMapper implements Mapper<City, CityDto> {

    public List<CityDto> listConvertToDto(List<City> entity){
        List<CityDto> result= new ArrayList<>();
        for (City city:entity) {
            CityDto cityDto = convertToDto(city);
            result.add(cityDto);
        }
        return result;
    }
    public List<City> listConvertToEntity(List<CityDto> dto){
        List<City> result= new ArrayList<>();
        for (CityDto cityDto:dto) {
            City cityEntity = convertToEntity(cityDto);
            result.add(cityEntity);
        }
        return result;
    }
    @Override
    public CityDto convertToDto(City dto) {
        CityDto cityDto = new CityDto();
        cityDto.setIdCity(dto.getIdCity());
        cityDto.setCityName(dto.getCityName());
        cityDto.setCountry(dto.getCountry());
        return cityDto;
    }

    @Override
    public City convertToEntity(CityDto entity) {
        City cityEntity = new City();
        cityEntity.setIdCity(entity.getIdCity());
        cityEntity.setCityName(entity.getCityName());
        cityEntity.setCountry(entity.getCountry());
        return cityEntity;
    }
}
