// package com.example.demo.security;

// import com.example.demo.model.User;
// import org.springframework.stereotype.Component;

// @Component
// public class JwtTokenProvider {

//     // Fake token format: TOKEN_userId_username
//     public String generateToken(User user) {
//         return "TOKEN_" + user.getId() + "_" + user.getUsername();
//     }

//     public boolean validateToken(String token) {
//         return token != null && token.startsWith("TOKEN_");
//     }

//     public Long getUserIdFromToken(String token) {
//         if (!validateToken(token)) {
//             throw new RuntimeException("Invalid token");
//         }
//         try {
//             return Long.parseLong(token.split("_")[1]);
//         } catch (Exception e) {
//             throw new RuntimeException("Invalid token format");
//         }
//     }
// }
