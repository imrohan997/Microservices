package com.microservice.ratingservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "rating")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    @Column
    String ratingId;
    @Column
    String hotelId;
    @Column
    String userId;
    @Column
    Integer rating;
    @Column
    String feedback;
}