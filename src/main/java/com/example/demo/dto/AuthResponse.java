package com.example.demo.dto;

import java.util.Collection;

public class AuthResponse {
    private String token;
    private String usernameOrEmail;
    private Collection<String> roles;

    public AuthResponse(String token, String usernameOrEmail, Collection<String> roles) {
        this.token = token;
        this.usernameOrEmail = usernameOrEmail;
        this.roles = roles;
    }

    // Getters and Setters
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getUsernameOrEmail() { return usernameOrEmail; }
    public void setUsernameOrEmail(String usernameOrEmail) { this.usernameOrEmail = usernameOrEmail; }

    public Collection<String> getRoles() { return roles; }
    public void setRoles(Collection<String> roles) { this.roles = roles; }
}