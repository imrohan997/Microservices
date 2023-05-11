package com.microservices.userservice.service;

import com.microservices.userservice.dto.UserDTO;
import com.microservices.userservice.entities.Hotel;
import com.microservices.userservice.entities.Rating;
import com.microservices.userservice.entities.User;
import com.microservices.userservice.exception.ResourceNotFoundException;
import com.microservices.userservice.repository.UserRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer which contains business logic of the user service.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRespository userRespository;

    @Autowired
    RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = userDTO.toEntity();
        return userRespository.save(user);
    }

    @Override
    public User getUser(String id) {
        User user = userRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with " + id + " is  not found."));
        //Get list of ratings for a particular user.
        Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + id, Rating[].class);
        logger.info("{}", ratings);

        //Convert ratings arrays into List.
        List<Rating> ratingsList = Arrays.asList(ratings);

        //Adding hotel information for each rating
        List<Rating> ratingsListWithHotelInfo = ratingsList.stream().map(rating -> {
            //Getting hotel information for each rating
            Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), Hotel.class);
            //Setting hotel into the rating extracted from RATING-SERVICE.
            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());

        //Setting updated rating list.
        user.setRatings(ratingsListWithHotelInfo);
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userRespository.findAll();
        users.stream().map(user -> {
          //Get list of ratings for a particular user.
          Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + user.getUserid(), Rating[].class);
          logger.info("{}", ratings);

          //Convert ratings arrays into List.
          List<Rating> ratingsList = Arrays.asList(ratings);

          //Adding hotel information for each rating
          List<Rating> ratingWithHotelInfo = ratingsList.stream().map(rating -> {
              //Getting hotel information for each rating
              Hotel hotel =restTemplate.getForObject("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), Hotel.class);
              //Setting hotel into the rating extracted from RATING-SERVICE.
              rating.setHotel(hotel);
              return rating;
          }).collect(Collectors.toList());

          //Setting updated rating list.
          user.setRatings(ratingWithHotelInfo);
          return user;

        }).collect(Collectors.toList());
        //List of users
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
