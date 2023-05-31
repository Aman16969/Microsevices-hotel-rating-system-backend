package com.example.hotel.service.imple;

import com.example.hotel.service.entities.Hotel;
import com.example.hotel.service.repository.HotelRepository;
import com.example.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImple implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        hotel.setHotelId(UUID.randomUUID().toString());
        Hotel newHotel=this.hotelRepository.save(hotel);
        return newHotel;
    }

    @Override
    public List<Hotel> getAllHotel() {
        List<Hotel> hotels=this.hotelRepository.findAll();
        return hotels;
    }

    @Override
    public Hotel getHotelById(String id) {
        Hotel hotel =this.hotelRepository.findById(id).orElseThrow();
        return hotel;
    }
}
