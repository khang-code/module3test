package com.example.quanlyphongtro.dao;

import com.example.quanlyphongtro.connection.JDBCConnection;
import com.example.quanlyphongtro.model.entity.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO implements IRoomDAO {

    // Method to retrieve all rooms from the database
    @Override
    public List<Room> findAllRoom() {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = JDBCConnection.getConnection()) {
            // Prepare the SQL query to select all rooms
            String sql = "SELECT * FROM room";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and map the data to Room objects
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String roomCode = resultSet.getString("room_code");
                String startDate = resultSet.getString("start_date");
                String paymentMethod = resultSet.getString("payment_method");
                String note = resultSet.getString("note");

                // Create a new Room object and add it to the list
                Room room = new Room(id, roomCode, startDate, paymentMethod, note);
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    // Method to find a room by its ID
    @Override
    public Room findRoomById(int id) {
        Room room = null;
        try (Connection connection = JDBCConnection.getConnection()) {
            // Prepare the SQL query to find a room by its ID
            String sql = "SELECT * FROM room WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            // If a room is found, map the result to a Room object
            if (resultSet.next()) {
                String roomCode = resultSet.getString("room_code");
                String startDate = resultSet.getString("start_date");
                String paymentMethod = resultSet.getString("payment_method");
                String note = resultSet.getString("note");

                room = new Room(id, roomCode, startDate, paymentMethod, note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    // Method to find rooms by their name or room code (partial match)
    @Override
    public List<Room> findRoomByName(String name) {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = JDBCConnection.getConnection()) {
            // Prepare the SQL query to find rooms by name (room_code or name like)
            String sql = "SELECT * FROM room WHERE room_code LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");  // Use LIKE for partial matching
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and map the data to Room objects
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String roomCode = resultSet.getString("room_code");
                String startDate = resultSet.getString("start_date");
                String paymentMethod = resultSet.getString("payment_method");
                String note = resultSet.getString("note");

                // Create a new Room object and add it to the list
                Room room = new Room(id, roomCode, startDate, paymentMethod, note);
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}

