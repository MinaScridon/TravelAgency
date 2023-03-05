package com.travel.travelAgency.service;

import com.travel.travelAgency.dto.HotelDto;
import com.travel.travelAgency.entities.Hotel;
import com.travel.travelAgency.exceptions.ResourceNotFoundException;
import com.travel.travelAgency.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class HotelService {
    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private HotelMapper hotelMapper;

    public List<HotelDto> findAllHotels() {
        return hotelRepo.findAll().stream().map(hotel -> hotelMapper
                .convertToDto(hotel)).collect(Collectors.toList());
    }

    public Optional<HotelDto> findById(Long idHotel) {
        Hotel hotel = hotelRepo.findByIdHotel(idHotel)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with the id " + idHotel + " not found"));
        return Optional.ofNullable(hotelMapper.convertToDto(hotel));
    }

    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel hotel = hotelMapper.convertToEntity(hotelDto);
        hotelRepo.save(hotel);
        return hotelMapper.convertToDto(hotel);
    }

    public HotelDto editHotel(Long idHotel, HotelDto hotelDto) {
        Hotel hotel = hotelRepo
                .findByIdHotel(idHotel)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with the id " + idHotel + " not found"));
        hotel.setHotelName(hotelDto.getHotelName());
        hotel.setDescription(hotelDto.getDescription());
        hotel.setDesignatedCity(hotelDto.getDesignatedCity());
        hotel.setNumberOfStars(hotelDto.getNumberOfStars());
        hotelRepo.save(hotel);

        return hotelMapper.convertToDto(hotel);
    }

    public void deleteHotel(String name){
        Hotel hotel = (Hotel) hotelRepo
                .findByHotelName(name)
                .orElseThrow(()->new ResourceNotFoundException("Hotel with the name " + name + " not found"));
        hotelRepo.delete(hotel);
    }
}
