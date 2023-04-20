package com.microservices.userservice.service;

import com.microservices.userservice.dto.UserDTO;
import com.microservices.userservice.entities.User;

import java.util.List;

public interface UserService {

    public User saveUser(UserDTO userDTO);

    public User getUser(String id);

    public List<User> getUsers();

    public void deleteUser(String id);

    public User updateUser(UserDTO userDTO, String userId);
}
