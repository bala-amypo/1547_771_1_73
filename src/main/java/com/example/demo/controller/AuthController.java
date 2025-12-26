package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
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
