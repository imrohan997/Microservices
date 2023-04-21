package com.microservices.userservice.service;

import com.microservices.userservice.dto.UserDTO;
import com.microservices.userservice.entities.User;
import com.microservices.userservice.exception.ResourceNotFoundException;
import com.microservices.userservice.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRespository userRespository;

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = userDTO.toEntity();
        return userRespository.save(user);
    }

    @Override
    public User getUser(String id) {
        User user = userRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with " + id + " is  not found."));
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userRespository.findAll();
        return users;
    }

    @Override
    public void deleteUser(String id) {
        User user = getUser(id);
        userRespository.delete(user);
    }

    @Override
    @Transactional
    public User updateUser(String about, String userId) {
        User user = getUser(userId);
        user.setAbout(about);
        return user;
    }
}
