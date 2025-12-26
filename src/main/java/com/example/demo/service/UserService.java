package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    User getUserByUsername(String username);

    List<User> getAllUsers();
}
