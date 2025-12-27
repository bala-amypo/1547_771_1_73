// package com.example.demo.security;

// import com.example.demo.model.User;
// import io.jsonwebtoken.*;
// import org.springframework.stereotype.Component;

// import java.util.Date;
// import java.util.stream.Collectors;

// @Component
// public class JwtTokenProvider {

//     private final String jwtSecret = "amypo-secret-key";
//     private final long jwtExpirationMs = 3600000; // 1 hour

//     public String generateToken(User user) {

//         return Jwts.builder()
//                 .setSubject(user.getUsername())
//                 .claim("userId", user.getId())
//                 .claim("email", user.getEmail())
//                 .claim(
//                     "roles",
//                     user.getRoles()
//                         .stream()
//                         .map(Role -> Role.getName())
//                         .collect(Collectors.toList())
//                 )
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
//                 .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                 .compact();
//     }

//     public String getUsernameFromToken(String token) {
//         return parseClaims(token).getSubject();
//     }

   
//     public Long getUserIdFromToken(String token) {
//         Object value = parseClaims(token).get("userId");
//         return value == null ? null : Long.valueOf(value.toString());
//     }

//     public boolean validateToken(String token) {
//         try {
//             parseClaims(token);
//             return true;
//         } catch (JwtException | IllegalArgumentException e) {
//             return false;
//         }
//     }

//     private Claims parseClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(jwtSecret)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }



package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-ms}")
    private long jwtExpirationMs;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateToken(String username) {

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSigningKey())
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
