package com.microservice.hotelservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(schema = "hotel")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @Column(name = "id")
    String id;
    @Column(name = "name")
    String name;
    @Column(name = "location")
    String location;
    @Column(name = "about", length = 1000)
    String about;
}
