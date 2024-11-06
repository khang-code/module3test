package com.example.quanlyphongtro.dao;

import com.example.quanlyphongtro.connection.JDBCConnection;
import com.example.quanlyphongtro.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    // Method to retrieve all users from the database
    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";  // Assuming the table name is "user"

        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {

            // Iterate through the result set and create User objects
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("ten_nguoi_dung");
                String phone = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");

                // Create User object and add it to the list
                User user = new User(id, name, phone, email);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving users: " + e.getMessage(), e);
        }
        return users;
    }
}
