package com.example.quanlyphongtro.dao;

import com.example.quanlyphongtro.model.entity.User;

import java.util.List;

public interface IUserDAO {
    List<User> findAllUsers();
}
