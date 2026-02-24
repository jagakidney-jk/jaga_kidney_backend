package com.jaga_kidney_backend.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil
{

  private final String SECRET =
      "mySecretKeymySecretKeymySecretKeymySecretKey";

  private final long ACCESS_TOKEN_VALIDITY = 1000 * 60 * 30; // 30 min
  private final long REFRESH_TOKEN_VALIDITY = 1000L * 60 * 60 * 24 * 7; // 7 days

  private Key getSigningKey()
  {
    return Keys.hmacShaKeyFor(SECRET.getBytes());
  }

  public String generateAccessToken(String username, String role)
  {

    return Jwts.builder()
        .setSubject(username)
        .claim("role", role)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis()
            + ACCESS_TOKEN_VALIDITY))
        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  public String generateRefreshToken(String username)
  {

    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis()
            + REFRESH_TOKEN_VALIDITY))
        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  public String extractUsername(String token)
  {

    return Jwts.parserBuilder()
        .setSigningKey(getSigningKey())
        .build()
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
  }

  public boolean validateToken(String token)
  {

    try
    {
      Jwts.parserBuilder()
          .setSigningKey(getSigningKey())
          .build()
          .parseClaimsJws(token);

      return true;
    }
    catch (JwtException e)
    {
      return false;
    }

  }

}
