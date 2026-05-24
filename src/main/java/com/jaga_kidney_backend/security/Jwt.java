package com.jaga_kidney_backend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Jwt {

    private final String SECRET = "mysecretkeymysecretkeymysecretkey12345"; 
    private final long EXPIRATION = 1000 * 60 * 30;

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(getSignKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    } 

    public String generateToken(String username, Integer user_seq, String role_code) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("user_seq", user_seq);
        claims.put("role_code", role_code);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getUserSeqFromToken(String token) {
        return extractAllClaims(token).get("user_seq", Integer.class);
    }

    public String getRoleCodeFromToken(String token) {
        return extractAllClaims(token).get("role_code", String.class);
    }
}