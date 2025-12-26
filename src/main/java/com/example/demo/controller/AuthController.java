package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        
        User registered = userService.registerUser(user, request.getRole());
        return ResponseEntity.ok(registered);
    }

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