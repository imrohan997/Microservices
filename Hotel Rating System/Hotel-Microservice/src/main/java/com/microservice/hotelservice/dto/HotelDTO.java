package com.microservice.hotelservice.dto;

import com.microservice.hotelservice.entities.Hotel;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class HotelDTO {

    @NotNull
    String name;
    @NotNull
    String location;
    String about;

    public Hotel toEntity() {
        return Hotel.builder()
                .id(UUID.randomUUID().toString())
                .name(this.name)
                .location(this.location)
                .about(this.about)
                .build();
    }
}
