package com.travel.travelAgency.service;

import com.travel.travelAgency.dto.CountryDto;
import com.travel.travelAgency.entities.Country;
import com.travel.travelAgency.exceptions.ResourceNotFoundException;
import com.travel.travelAgency.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {
    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private CountryMapper countryMapper;

    public List<CountryDto> findAllCountries() {
        return countryRepo.findAll().stream().map(country -> countryMapper
                .convertToDto(country)).collect(Collectors.toList());
    }

    public Optional<CountryDto> findById(Long idCountry) {
        Country country = countryRepo.findByIdCountry(idCountry)
                .orElseThrow(() -> new ResourceNotFoundException("Country with the id " + idCountry + " not found"));
        return Optional.ofNullable(countryMapper.convertToDto(country));
    }

    public CountryDto createCountry(CountryDto countryDto) {
        Country country = countryMapper.convertToEntity(countryDto);
        countryRepo.save(country);
        return countryMapper.convertToDto(country);
    }

    public CountryDto editCountry(Long idCountry, CountryDto countryDto) {
        Country country = countryRepo
                .findByIdCountry(idCountry)
                .orElseThrow(() -> new ResourceNotFoundException("Country with the id " + idCountry + " not found"));
        country.setCountryName(countryDto.getCountryName());
        country.setContinent(countryDto.getContinent());
        countryRepo.save(country);

        return countryMapper.convertToDto(country);
    }

    public void deleteCountry(String name){
        Country country = (Country) countryRepo
                .findByCountryName(name)
                .orElseThrow(()->new ResourceNotFoundException("Country with the name " + name + " not found"));
        countryRepo.delete(country);
    }
}
