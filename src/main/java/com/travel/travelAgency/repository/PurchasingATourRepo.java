package com.travel.travelAgency.repository;

import com.travel.travelAgency.entities.PurchasingATour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PurchasingATourRepo extends JpaRepository<PurchasingATour, Long> {
    Optional<PurchasingATour> findByIdPurchasingATour(Long id);
}
