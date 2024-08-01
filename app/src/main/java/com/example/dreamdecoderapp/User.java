package com.example.dreamdecoderapp;

public class User {
    private int id;
    private String email;
    private String password;

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return email;
    }
}
