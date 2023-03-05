package com.travel.travelAgency.repository;

import com.travel.travelAgency.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findByIdHotel(Long idHotel);

    Optional<Object> findByHotelName(String name);

}
