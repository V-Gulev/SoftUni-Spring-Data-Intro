package com.example.demo.services;

import com.example.demo.entities.User;

import java.util.Optional;

public interface UserService {
    void registerUser(User user);

    Optional<User> find(String username);
}
