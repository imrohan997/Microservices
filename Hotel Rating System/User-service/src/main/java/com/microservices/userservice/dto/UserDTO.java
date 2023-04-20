package com.microservices.userservice.dto;

import com.microservices.userservice.entities.User;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UserDTO {


    @NotNull
    String name;
    @NotNull
    String emailId;
    String about;

    public User toEntity() {
      return  User.builder()
                .userid(UUID.randomUUID().toString())
                .name(this.name)
                .email(this.emailId)
                .about(this.about)
                .build();
    }
}
