package com.example.demo.security;

public class SecurityConstants {
    // Secret key for signing JWTs
    public static final String SECRET = "SecretKeyToGenJWTsWithHighEntropyRequiredForRecentVersions";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}