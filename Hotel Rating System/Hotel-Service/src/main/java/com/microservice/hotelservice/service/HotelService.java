package com.microservice.hotelservice.service;

import com.microservice.hotelservice.dto.HotelDTO;
import com.microservice.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel createHotel(HotelDTO hotelDTO);

    public Hotel getHotel(String id);

    public List<Hotel> getHotels();

    public void deleteHotel(String id);
    public Hotel updateHotel(HotelDTO hotelDTO, String id);
}
