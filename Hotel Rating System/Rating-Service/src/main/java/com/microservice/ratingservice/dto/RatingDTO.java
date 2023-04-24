package com.microservice.ratingservice.dto;

import com.microservice.ratingservice.entities.Rating;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class RatingDTO {

    @NotNull
    String hotelId;
    @NotNull
    String userId;
    @NotNull
    Integer rating;
    String feedback;

    public Rating toEntity() {
        return Rating.builder()
                .ratingId(UUID.randomUUID().toString())
                .hotelId(this.hotelId)
                .userId(this.userId)
                .rating(this.rating)
                .feedback(this.feedback)
                .build();
    }
}
