package com.microservices.userservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "user")
@Getter
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
    @Column(name = "about", length = 20)
    String about;
}
