package com.example.quanlyphongtro.service;

import com.example.quanlyphongtro.dao.RoomDAO;
import com.example.quanlyphongtro.model.entity.Room;

import java.util.List;

public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();

    public List<Room> findAllRooms() {
        return roomDAO.findAllRoom();
    }

    public List<Room> findRoomByName(String name) {
        return roomDAO.findRoomByName(name);
    }
}
