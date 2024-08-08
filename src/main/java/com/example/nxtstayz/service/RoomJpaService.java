package com.example.nxtstayz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import com.example.nxtstayz.repository.*;
import com.example.nxtstayz.model.*;

@Service
public class RoomJpaService implements RoomRepository {

    @Autowired
    private HotelJpaRepository hotelJpaRepository;
    @Autowired
    private RoomJpaRepository roomJpaRepository;

    @Override
    public ArrayList<Room> getAllRooms() {
        List<Room> roomlist = roomJpaRepository.findAll();
        ArrayList<Room> rooms = new ArrayList<>(roomlist);
        return rooms;
    }

    @Override
    public Room getRoomById(int roomId) {
        try {
            Room room = roomJpaRepository.findById(roomId);
            return room;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Room addRoom(Room room) {
        try {
            int hotelId = room.getHotel().getHotelById();
            Hotel hotel = hotelJpaRepository.findById(hotelId).get();
            room.setHotel(hotel);
            return roomJpaRepository.save(room);
        } catch (NoSuchException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override 
    public Room updateRoom(int roomId,Room room){
        try{
            Room newroom =roomJpaRepository.findById(roomId);
            if(room.getRoomName()!=null){
                newroom.setRoomName(room.getRoomName());
            }
            if(room.getRoomType()!=null){
                newroom.setType(room.getRoomType();)
            }
            if(room.getPrice()!=0){
                newroom.setPrice(room.getPrice());
            }
            if(room.getHotel()!=null){
                Hotel hotel= room.getByHotel(hotel);
                int hotelId= hotel.getHotelId();
                Hotel newhotel= hotelJpaRepository.findById(hotelId).get();
                newroom.setHotel(newhotel);

            }
            return roomJpaRepository.save(newroom);

        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteRoom(int roomId) {
        try {
            roomJpaRepository.deleteById(roomId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Hotel getRoomOfHotel(int roomId) {
        try {
            Room room = roomJpaRepository.findById(roomId).get();
            Hotel hotel = room.getHotel();
            return hotel;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
    }

}
