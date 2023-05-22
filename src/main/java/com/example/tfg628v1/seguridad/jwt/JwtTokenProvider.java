package com.example.tfg628v1.seguridad.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
  public static final String TOKEN_HEADER = "Authorization";
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String TOKEN_TYPE = "JWT";

  @Value("${jwt.secret}")
  private String jwtSecret;

  // Valor obtenido del application.properties
  @Value("${jwt.expiration:86400}")
  private int jwtExpiration;

  private Key getSigningKey() {
    return Keys.hmacShaKeyFor(jwtSecret.getBytes());
  }

  public String generateToken(UserDetails userDetails) {

    return Jwts.builder()
      .signWith(getSigningKey(), SignatureAlgorithm.HS512)
      .setHeaderParam("typ", TOKEN_TYPE)
      .setSubject((userDetails.getUsername()))
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + (jwtExpiration * 1000)))

      .compact();
  }

  public String getUsernameFromJwtToken(String token) {
    return Jwts.parserBuilder()
      .setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateToken(String authToken) {
    try {
      Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(authToken);
      return true;
    } catch (MalformedJwtException e) {
      log.error("Token JWT malformado: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      log.error("El token JWT ha expirado: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      log.error("Token JWT no soportado: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      log.error("JWT claims vacío: {}", e.getMessage());
    }

    return false;
  }
}
