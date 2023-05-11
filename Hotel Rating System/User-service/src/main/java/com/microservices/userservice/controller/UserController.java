package com.microservices.userservice.controller;

import com.microservices.userservice.dto.UserDTO;
import com.microservices.userservice.entities.User;
import com.microservices.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class which exposes various end points to the outside world.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Saves user to database.
     * @param userDTO
     * @return
     */
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@Validated @RequestBody UserDTO userDTO) {
        User user = userService.saveUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Get user by userId.
     * @param userId
     * @return
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Get list of all users from database.
     * @return
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    /**
     * Deletes user from database on the basis of userId.
     * @param userId
     */
    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

    /**
     * Updates user in database on the basis of userId.
     * @param about
     * @param userId
     * @return
     */
    @PatchMapping("/user/{userId}")
    public ResponseEntity<User> updateUser(@RequestParam String about, @PathVariable String userId) {
        User user = userService.updateUser(about, userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
