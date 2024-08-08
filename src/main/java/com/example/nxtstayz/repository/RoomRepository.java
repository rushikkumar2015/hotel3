package com.example.nxtstayz.repository;

import java.util.ArrayList;

import com.example.nxtstayz.model.*;

public interface RoomRepository {
  ArrayList<Room> getAllRooms();

  Room getRoomById(int roomId);

  Room addRoom(Room room);

  Room updateRoom(int roomId, Room room);

  void deleteRoom(int roomId);

  Hotel getRoomOfHotel(int roomId);
}
