package com.travel.travelAgency.repository;

import com.travel.travelAgency.entities.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContinentRepo extends JpaRepository<Continent, Long> {
    Optional<Continent> findByIdContinent(Long idContinent);

    Optional<Object> findByContinentName(String name);

}
