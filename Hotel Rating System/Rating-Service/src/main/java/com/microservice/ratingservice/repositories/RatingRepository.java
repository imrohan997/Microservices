package com.microservice.ratingservice.repositories;

import com.microservice.ratingservice.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {

    //custom finders
    public List<Rating> findByHotelId(String hotelId);
    public List<Rating> findByUserId(String userId);
}
