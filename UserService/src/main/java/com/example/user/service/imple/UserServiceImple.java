package com.example.user.service.imple;

import com.example.user.service.enitities.Hotel;
import com.example.user.service.enitities.Rating;
import com.example.user.service.enitities.User;
import com.example.user.service.external.service.HotelService;
import com.example.user.service.repository.UserRepository;


import com.example.user.service.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImple implements UserServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserServiceImple.class);



    @Override
    public User createUser(User user) {
        User newUser=this.userRepository.save(user);
        return newUser;
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUsers=this.userRepository.findAll();
        return allUsers;
    }

    @Override
    public User getUserById(String userId) {
        User user=this.userRepository.findById(userId).orElseThrow();
        Rating[]  ratingArray=restTemplate.getForObject("http://RATING-SERVICE/api/rating/user/"+user.getUserId(), Rating[].class);
        List<Rating> ratings= Arrays.stream(ratingArray).collect(Collectors.toList());
        logger.info("{}",ratings);

        List<Rating> ratingList=ratings.stream().map(rating->{
//            ResponseEntity<Hotel> hotelEntity= restTemplate.getForEntity("http://HOTEL-SERVICE/api/hotel/"+rating.getHotelId(), Hotel.class);
            Hotel hotel=hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratings);
        return user;


    }

    @Override
    public void deleteUserById(String userId) {
        User user=this.userRepository.findById(userId).orElseThrow();
        this.userRepository.delete(user);
    }

    @Override
    public User updateUserById(String userId, User user) {
        User u=this.userRepository.findById(userId).orElseThrow();
        u.setAbout(user.getAbout());
        u.setName(user.getName());
        User updatedUser=this.userRepository.save(u);
        return updatedUser;

    }
}
