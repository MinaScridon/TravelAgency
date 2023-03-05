package com.travel.travelAgency.controller;

import com.travel.travelAgency.dto.HotelDto;
import com.travel.travelAgency.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("/hotels")
    public ResponseEntity<List<HotelDto>> findAllTheHotels (){
        List<HotelDto> allHotels = hotelService.findAllHotels();
        return new ResponseEntity<>(allHotels, HttpStatus.OK);
    }

    @GetMapping("/hotels/{idHotel}")
    public ResponseEntity<HotelDto> findByIdHotel(@PathVariable Long idHotel){
        HotelDto hotelDto = hotelService.findById(idHotel).get();
        return new ResponseEntity<>(hotelDto, HttpStatus.OK);
    }

    @PostMapping("/createHotel")
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto){
        HotelDto hotelDto1 = hotelService.createHotel(hotelDto);
        return new ResponseEntity<>(hotelDto1, HttpStatus.OK);
    }

    @PutMapping("/editHotel/{idHotel}")
    public ResponseEntity<HotelDto> editHotel(@RequestBody HotelDto hotelDto , @PathVariable Long idHotel){
        HotelDto hotelDto1 = hotelService.editHotel(idHotel,hotelDto);

        return new ResponseEntity<>(hotelDto1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteHotel/{hotelName}")
    public ResponseEntity<?> deleteHotel(@PathVariable String hotelName){
        hotelService.deleteHotel(hotelName);
        return new ResponseEntity<>("The Hotel with name " + hotelName + " has been deleted successfully.", HttpStatus.OK);
    }
}
