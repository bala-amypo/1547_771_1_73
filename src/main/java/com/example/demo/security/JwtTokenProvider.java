// // package com.example.demo.security;

// // import com.example.demo.model.User;
// // import org.springframework.stereotype.Component;

// // @Component
// // public class JwtTokenProvider {

// //     // Fake token format: TOKEN_userId_username
// //     public String generateToken(User user) {
// //         return "TOKEN_" + user.getId() + "_" + user.getUsername();
// //     }

// //     public boolean validateToken(String token) {
// //         return token != null && token.startsWith("TOKEN_");
// //     }

// //     public Long getUserIdFromToken(String token) {
// //         if (!validateToken(token)) {
// //             throw new RuntimeException("Invalid token");
// //         }
// //         try {
// //             return Long.parseLong(token.split("_")[1]);
// //         } catch (Exception e) {
// //             throw new RuntimeException("Invalid token format");
// //         }
// //     }
// // }



// package com.example.demo.security;

// import com.example.demo.model.User;
// import io.jsonwebtoken.*;
// import org.springframework.stereotype.Component;

// import java.util.Date;
// import java.util.stream.Collectors;

// @Component
// public class JwtTokenProvider {

//     private final String secret = "secretKey";
//     private final long validity = 3600000;

//     public String generateToken(User user) {
//         return Jwts.builder()
//                 .setSubject(user.getUsername())
//                 .claim("uid", user.getId())
//                 .claim("roles",
//                         user.getRoles().stream()
//                                 .map(r -> r.getName())
//                                 .collect(Collectors.toList()))
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + validity))
//                 .signWith(SignatureAlgorithm.HS256, secret)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public Long getUserIdFromToken(String token) {
//         Claims c = Jwts.parser().setSigningKey(secret)
//                 .parseClaimsJws(token).getBody();
//         return c.get("uid", Long.class);
//     }
// }
