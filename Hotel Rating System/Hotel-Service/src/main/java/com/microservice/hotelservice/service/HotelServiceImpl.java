package com.microservice.hotelservice.service;

import com.microservice.hotelservice.dto.HotelDTO;
import com.microservice.hotelservice.entities.Hotel;
import com.microservice.hotelservice.exception.ResourceNotFound;
import com.microservice.hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(HotelDTO hotelDTO) {
        Hotel hotel = hotelDTO.toEntity();
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFound());
    }

    @Override
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public void deleteHotel(String id) {
        Hotel hotel = getHotel(id);
        hotelRepository.delete(hotel);
    }

    @Override
    public Hotel updateHotel(HotelDTO hotelDTO, String id) {
        Hotel hotel = getHotel(id);
        hotel.setName(hotelDTO.getName());
        hotel.setAbout(hotelDTO.getAbout());
        hotel.setLocation(hotelDTO.getLocation());
        return hotel;
    }
}
