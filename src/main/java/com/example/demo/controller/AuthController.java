package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.Service.UserService;
import com.example.demo.model.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user,
                         @RequestParam String roleName) {
        return userService.registerUser(user, roleName);
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
