package com.travel.travelAgency.repository;

import com.travel.travelAgency.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
    Optional<Country> findByIdCountry(Long idCountry);

    Optional<Object> findByCountryName(String name);

}
