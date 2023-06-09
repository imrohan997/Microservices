package com.microservices.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class to store rating.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    String ratingId;
    String hotelId;
    String userId;
    Integer rating;

    Hotel hotel;
}
