package com.travel.travelAgency.repository;

import com.travel.travelAgency.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Long> {
    Optional<Airport> findByIdAirport(Long idAirport);

    Optional<Object> findByAirportName(String airportName);
}
