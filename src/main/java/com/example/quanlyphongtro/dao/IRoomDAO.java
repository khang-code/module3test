package com.example.quanlyphongtro.dao;

import com.example.quanlyphongtro.model.entity.Room;

import java.util.List;

public interface IRoomDAO {
    List<Room> findAllRoom();
    Room findRoomById(int id);
    List<Room> findRoomByName(String name);
}
