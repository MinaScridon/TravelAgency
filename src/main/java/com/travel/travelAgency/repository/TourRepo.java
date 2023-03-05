package com.travel.travelAgency.repository;

import com.travel.travelAgency.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourRepo extends JpaRepository<Tour, Long> {

    Optional<Object> findTourByIdTour(Long idTour);

    Optional<Object> findTourByTourName(String tourName);
}
