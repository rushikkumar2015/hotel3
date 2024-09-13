package com.example.nxtstayz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.nxtstayz.model.*;
import com.example.nxtstayz.service.HotelJpaService;

@RestController
public class HotelController {
    @Autowired
    private HotelJpaService hoteljpaservice;

    @GetMapping("/hotels")
    public ArrayList<Hotel> getHotels() {
        return hoteljpaservice.getHotels();
    }

    @GetMapping("/hotels/{hotelId}")
    public Hotel getHotelById(@PathVariable("hotelId") int hotelId) {
        return hoteljpaservice.getHotelById(hotelId);
    }

    @PostMapping("/hotels")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hoteljpaservice.addHotel(hotel);
    }

    @PutMapping("/hotels/{hotelId}")
    public Hotel updateHotel(@PathVariable("hotelId") int hotelId, @RequestBody Hotel hotel) {
        return hoteljpaservice.updateHotel(hotelId, hotel);
    }

    @DeleteMapping("/hotels/{hotelId}")
    public void deleteHotel(@PathVariable("hotelId") int hotelId) {
        hoteljpaservice.deleteHotel(hotelId);

    }

    @GetMapping("/hotels/{hotelId}/rooms")
    public List<Room> getHotelRoom(@PathVariable("hotelId") int hotelId) {
        return hoteljpaservice.getHotelRoom(hotelId);
    }

}