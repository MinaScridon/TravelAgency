package com.travel.travelAgency.repository;

import com.travel.travelAgency.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
    Optional<City> findByIdCity(Long idCity);

    Optional<Object> findByCityName(String name);

}
