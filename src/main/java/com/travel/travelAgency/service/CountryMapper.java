package com.travel.travelAgency.service;

import com.travel.travelAgency.dto.CountryDto;
import com.travel.travelAgency.entities.Country;
import com.travel.travelAgency.mapper.Mapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class CountryMapper implements Mapper<Country, CountryDto> {

    public List<CountryDto> listConvertToDto(List<Country> entity){
        List<CountryDto> result= new ArrayList<>();
        for (Country country:entity) {
            CountryDto countryDto = convertToDto(country);
            result.add(countryDto);
        }
        return result;
    }
    public List<Country> listConvertToEntity(List<CountryDto> dto){
        List<Country> result= new ArrayList<>();
        for (CountryDto countryDto:dto) {
            Country convertEntity = convertToEntity(countryDto);
            result.add(convertEntity);
        }
        return result;
    }
    @Override
    public CountryDto convertToDto(Country entity) {
        CountryDto countryDto = new CountryDto();
        countryDto.setIdCountry(entity.getIdCountry());
        countryDto.setCountryName(entity.getCountryName());
        countryDto.setContinent(entity.getContinent());
        return countryDto;
    }

    @Override
    public Country convertToEntity(CountryDto dto) {
        Country countryEntity = new Country();
        countryEntity.setIdCountry(dto.getIdCountry());
        countryEntity.setCountryName(dto.getCountryName());
        countryEntity.setContinent(dto.getContinent());
        return countryEntity;
    }
}
