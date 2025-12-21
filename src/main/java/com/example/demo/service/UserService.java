package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User registerUser(User user, String roleName);

    User findByUsername(String username);

    boolean checkPassword(String rawPassword, String encodedPassword);
}
