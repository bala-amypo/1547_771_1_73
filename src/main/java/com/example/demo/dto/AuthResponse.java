package com.example.demo.dto;

import java.util.Collection;

public class AuthResponse {
    private String token;
    private String username;
    private Collection<String> roles;

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public Collection<String> getRoles() { return roles; }
    public void setRoles(Collection<String> roles) { this.roles = roles; }
}