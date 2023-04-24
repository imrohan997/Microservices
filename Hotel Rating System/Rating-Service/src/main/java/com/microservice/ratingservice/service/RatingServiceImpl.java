package com.microservice.ratingservice.service;

import com.microservice.ratingservice.dto.RatingDTO;
import com.microservice.ratingservice.entities.Rating;
import com.microservice.ratingservice.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository hotelRepository;
    @Override
    public Rating createRating(RatingDTO ratingDTO) {
        return hotelRepository.save(ratingDTO.toEntity());
    }

    @Override
    public List<Rating> getAllRating() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUser(String userId) {
        return hotelRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotel(String hotelId) {
        return hotelRepository.findByHotelId(hotelId);
    }
}
