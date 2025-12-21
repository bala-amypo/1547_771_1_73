package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userService.registerUser(user, request.getRole());
        return "REGISTER_OK";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        User user = userService.findByUsername(request.getUsername());

        if (user != null &&
            userService.checkPassword(request.getPassword(), user.getPassword())) {

            
            String token = jwtTokenProvider.generateToken(user.getUsername());
            return new AuthResponse(token);
        }

        return new AuthResponse("invalid-login");
    }
}

