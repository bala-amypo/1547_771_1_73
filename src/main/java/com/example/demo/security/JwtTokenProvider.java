package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    // ----------------------------------------------------
    // Generate JWT token
    // ----------------------------------------------------
    public String generateToken(Authentication authentication) {

        String username = authentication.getName();

        List<String> roles = authentication.getAuthorities()
                .stream()
                .map(a -> a.getAuthority())
                .collect(Collectors.toList());

        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();
    }

    // ----------------------------------------------------
    // Get username from token
    // ----------------------------------------------------
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // ----------------------------------------------------
    // Validate token
    // ----------------------------------------------------
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SecurityConstants.SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // ----------------------------------------------------
    // Build Authentication object
    // ----------------------------------------------------
    public Authentication getAuthentication(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
                .parseClaimsJws(token)
                .getBody();

        List<String> roles = claims.get("roles", List.class);

        List<SimpleGrantedAuthority> authorities =
                roles.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(
                claims.getSubject(),
                null,
                authorities
        );
    }
}
