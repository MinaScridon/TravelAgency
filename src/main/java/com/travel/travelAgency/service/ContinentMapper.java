package com.travel.travelAgency.service;

import com.travel.travelAgency.dto.ContinentDto;
import com.travel.travelAgency.entities.Continent;
import com.travel.travelAgency.mapper.Mapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class ContinentMapper implements Mapper<Continent, ContinentDto> {

    public List<ContinentDto> listConvertToDto(List<Continent> entity){
        List<ContinentDto> result= new ArrayList<>();
        for (Continent continent:entity) {
            ContinentDto continentDto = convertToDto(continent);
            result.add(continentDto);
        }
        return result;
    }
    public List<Continent> listConvertToEntity(List<ContinentDto> dto){
        List<Continent> result= new ArrayList<>();
        for (ContinentDto continentDto1:dto) {
            Continent convertEntity = convertToEntity(continentDto1);
            result.add(convertEntity);
        }
        return result;
    }

    @Override
    public ContinentDto convertToDto(Continent entity) {
        ContinentDto continentDto = new ContinentDto();
        continentDto.setIdContinent(entity.getIdContinent());
        continentDto.setContinentName(entity.getContinentName());
        return continentDto;
    }

    @Override
    public Continent convertToEntity(ContinentDto dto) {
        Continent continentEntity = new Continent();
        continentEntity.setIdContinent(dto.getIdContinent());
        continentEntity.setContinentName(dto.getContinentName());
        return continentEntity;
    }
}
