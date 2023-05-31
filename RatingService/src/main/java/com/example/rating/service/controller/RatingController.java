package com.example.rating.service.controller;


import com.example.rating.service.entities.Rating;
import com.example.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping("/")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating rating1=this.ratingService.createRating(rating);
        return new ResponseEntity<>(rating1, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<Rating>> getAllRating(){
        List<Rating> ratings=this.ratingService.getAllRating();
        return ResponseEntity.ok(ratings);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingByUser(@PathVariable String userId){
        List<Rating> ratings=this.ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok((ratings));
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingByHotel(@PathVariable String hotelId){
        List<Rating> ratings=this.ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.ok((ratings));
    }
}
