package com.microservice.ratingservice.controller;

import com.microservice.ratingservice.dto.RatingDTO;
import com.microservice.ratingservice.entities.Rating;
import com.microservice.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping("/rating")
    public ResponseEntity<Rating> createRating(@RequestBody RatingDTO ratingDTO) {
        Rating rating = ratingService.createRating(ratingDTO);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }

    @GetMapping("/rating")
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.getAllRating();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/rating/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
        List<Rating> ratings = ratingService.getRatingByUser(userId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/rating/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
        List<Rating> ratings = ratingService.getRatingByHotel(hotelId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

}
