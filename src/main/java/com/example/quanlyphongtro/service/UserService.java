package com.example.quanlyphongtro.service;

import com.example.quanlyphongtro.dao.IUserDAO;
import com.example.quanlyphongtro.dao.UserDAO;
import com.example.quanlyphongtro.model.entity.User;

import java.util.List;

public class UserService implements IUserService {
    private final IUserDAO userDAO = new UserDAO();

    @Override
    public List<User> findAllUsers() {
        // Corrected to call the method on userDAO
        return userDAO.findAllUsers();  // Proper method invocation
    }
}
