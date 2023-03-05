package com.travel.travelAgency.service;

import com.travel.travelAgency.dto.HotelDto;
import com.travel.travelAgency.entities.Hotel;
import com.travel.travelAgency.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HotelMapper implements Mapper<Hotel, HotelDto> {
    public List<HotelDto> listConvertToDto(List<Hotel> entity){
        List<HotelDto> result= new ArrayList<>();
        for (Hotel hotel:entity) {
            HotelDto hotelDto = convertToDto(hotel);
            result.add(hotelDto);
        }
        return result;
    }
    public List<Hotel> listConvertToEntity(List<HotelDto> dto){
        List<Hotel> result= new ArrayList<>();
        for (HotelDto hotelDto:dto) {
            Hotel convertEntity = convertToEntity(hotelDto);
            result.add(convertEntity);
        }
        return result;
    }
    @Override
    public HotelDto convertToDto(Hotel entity) {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setIdHotel(entity.getIdHotel());
        hotelDto.setHotelName(entity.getHotelName());
        hotelDto.setDescription(entity.getDescription());
        hotelDto.setDesignatedCity(entity.getDesignatedCity());
        hotelDto.setNumberOfStars(entity.getNumberOfStars());
        return hotelDto;
    }

    @Override
    public Hotel convertToEntity(HotelDto dto) {
        Hotel hotelEntity = new Hotel();
        hotelEntity.setIdHotel(dto.getIdHotel());
        hotelEntity.setHotelName(dto.getHotelName());
        hotelEntity.setDescription(dto.getDescription());
        hotelEntity.setDesignatedCity(dto.getDesignatedCity());
        hotelEntity.setNumberOfStars(dto.getNumberOfStars());
        return hotelEntity;
    }
}
