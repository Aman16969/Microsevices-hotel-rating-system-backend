package com.example.user.service.external.service;

import com.example.user.service.enitities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("api/hotel/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
