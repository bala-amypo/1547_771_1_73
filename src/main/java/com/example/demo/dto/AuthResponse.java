package com.example.demo.dto;

import lombok.Data;
import java.util.Collection;

@Data
public class AuthResponse {
    private String token;
    private String username; // Could be username or email per Helper Doc
    private Collection<String> roles; // Collection of role names
}