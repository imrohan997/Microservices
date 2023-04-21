package com.microservices.userservice.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    String userid;
    @Column(name = "name")
    String name;
    @Column(name = "email", unique = true)
    String email;
    @Column(name = "about", length = 1000)
    String about;

    @Transient
    List<Rating> ratings = new ArrayList<>();
}
