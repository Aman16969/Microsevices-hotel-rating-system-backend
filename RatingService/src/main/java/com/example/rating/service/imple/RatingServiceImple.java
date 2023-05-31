package com.example.rating.service.imple;

import com.example.rating.service.entities.Rating;
import com.example.rating.service.repository.RatingRepository;
import com.example.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImple implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating createRating(Rating rating) {
        Rating newRating=this.ratingRepository.save(rating);
        return newRating;
    }

    @Override
    public List<Rating> getAllRating() {
        List<Rating> ratings=this.ratingRepository.findAll();
        return ratings;
    }

    @Override
    public Rating getRatingById(String ratingId) {
        Rating rating=this.ratingRepository.findById(ratingId).orElseThrow();
        return rating;
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        List<Rating> ratings=this.ratingRepository.findByUserId(userId);
        return ratings;
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        List<Rating> ratings=this.ratingRepository.findByHotelId(hotelId);
        return ratings;
    }
}
