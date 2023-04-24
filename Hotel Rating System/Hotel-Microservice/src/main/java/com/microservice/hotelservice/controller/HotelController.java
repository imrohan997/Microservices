package com.microservice.hotelservice.controller;

import com.microservice.hotelservice.dto.HotelDTO;
import com.microservice.hotelservice.entities.Hotel;
import com.microservice.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/hotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody HotelDTO hotelDTO) {
        Hotel hotel = hotelService.createHotel(hotelDTO);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
        Hotel hotel = hotelService.getHotel(hotelId);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getHotels() {
        List<Hotel> hotels = hotelService.getHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @DeleteMapping("/hotel/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable String hotelId) {
        hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/hotel/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@Validated @RequestBody HotelDTO hotelDTO, @PathVariable String hotelId) {
        Hotel hotel = hotelService.updateHotel(hotelDTO, hotelId);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

}
