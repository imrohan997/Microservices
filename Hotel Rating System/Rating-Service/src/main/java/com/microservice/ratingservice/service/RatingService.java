package com.microservice.ratingservice.service;

import com.microservice.ratingservice.dto.RatingDTO;
import com.microservice.ratingservice.entities.Rating;

import java.util.List;

public interface RatingService {

    public Rating createRating(RatingDTO ratingDTO);

    public List<Rating> getAllRating();

    public List<Rating> getRatingByUser(String userId);

    public List<Rating> getRatingByHotel(String hotelId);
}
