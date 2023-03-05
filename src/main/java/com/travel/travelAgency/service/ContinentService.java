package com.travel.travelAgency.service;


import com.travel.travelAgency.dto.ContinentDto;
import com.travel.travelAgency.entities.Continent;
import com.travel.travelAgency.exceptions.ResourceNotFoundException;
import com.travel.travelAgency.repository.ContinentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContinentService {
    @Autowired
    private ContinentRepo continentRepo;

    @Autowired
    private ContinentMapper continentMapper;

    public List<ContinentDto> findAllContinents() {
        return continentRepo.findAll().stream().map(continent -> continentMapper
                .convertToDto(continent)).collect(Collectors.toList());
    }

    public Optional<ContinentDto> findById(Long idContinent) {
        Continent continent = continentRepo.findByIdContinent(idContinent)
                .orElseThrow(() -> new ResourceNotFoundException("Continent with the name " + idContinent + " not found"));
        return Optional.ofNullable(continentMapper.convertToDto(continent));
    }

    public ContinentDto createContinent(ContinentDto continentDto) {
        Continent continent = continentMapper.convertToEntity(continentDto);
        continentRepo.save(continent);
        return continentMapper.convertToDto(continent);
    }

    public ContinentDto editContinent(Long idContinent, ContinentDto continentDto) {
        Continent continent = continentRepo
                .findByIdContinent(idContinent)
                .orElseThrow(() -> new ResourceNotFoundException("Continent with the id " + idContinent + " not found"));
        continent.setContinentName(continentDto.getContinentName());
        continentRepo.save(continent);

        return continentMapper.convertToDto(continent);
    }

    public void deleteContinent(String name){
        Continent continent = (Continent) continentRepo
                .findByContinentName(name)
                .orElseThrow(()->new ResourceNotFoundException("Continent with the name " + name + " not found"));
        continentRepo.delete(continent);
    }
}
