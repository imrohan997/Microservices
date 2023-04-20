package com.microservices.userservice.repository;

import com.microservices.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, String> {
}
