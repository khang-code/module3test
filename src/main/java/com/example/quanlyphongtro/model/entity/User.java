package com.example.quanlyphongtro.model.entity;

public class User {
    private Long id;
    private String name;
    private String phone;
    private String email;

    public User(Long id, String name, String phone, String email) {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
