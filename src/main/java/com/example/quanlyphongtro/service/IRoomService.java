package com.example.quanlyphongtro.service;

import com.example.quanlyphongtro.model.entity.Room;

import java.util.List;

public interface IRoomService {
    List<Room> findAllRoom();
    Room findRoomById(int id);
    List<Room> findRoomByName(String name);
}
