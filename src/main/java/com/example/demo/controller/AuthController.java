package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // ----------------------------------------------------
    // Register new user
    // ----------------------------------------------------
    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestBody RegisterRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User saved = userService.registerUser(user, request.getRole());
        return ResponseEntity.ok(saved);
    }

    // ----------------------------------------------------
    // Login user and return JWT
    // ----------------------------------------------------
   @PostMapping("/login")
public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
    User user = userService.findByUsernameOrEmail(request.getUsername());

    AuthResponse response = new AuthResponse();
    response.setUsername(user.getUsername());
    response.setRole(user.getRole().getName());
    response.setMessage("Login successful");

    return ResponseEntity.ok(response);


    }
}
