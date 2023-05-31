package com.example.hotel.service.controller;

import com.example.hotel.service.entities.Hotel;
import com.example.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("/")
    public ResponseEntity<Hotel> createHotel(@RequestBody  Hotel hotel){
        Hotel newHotel=this.hotelService.createHotel(hotel);
        return new ResponseEntity<>(newHotel, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<Hotel>> getAllHotel(){
        List<Hotel> hotels=this.hotelService.getAllHotel();
        return new ResponseEntity<>(hotels, HttpStatus.CREATED);
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        Hotel newHotel=this.hotelService.getHotelById(hotelId);
        return new ResponseEntity<>(newHotel, HttpStatus.CREATED);
    }

}
