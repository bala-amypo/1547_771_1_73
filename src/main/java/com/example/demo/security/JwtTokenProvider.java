package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    
    public String generateToken(String username) {
        return "dummy-token-for-" + username;
    }

   
    public String generateToken(User user) {
        return generateToken(user.getUsername());
    }

    public boolean validateToken(String token) {
        return token != null && !token.isEmpty();
    }

    public Long getUserIdFromToken(String token) {
        return 1L;
    }
}
