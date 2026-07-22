//package com.jobapprest.jobapprest.service;
//
//import com.jobapprest.jobapprest.dto.LoginDto;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//
//@Service
//public class JwtService {
//    @Value("${jwt.secretKey}")
//    private  String secretKey;
//
//    private SecretKey getSecretKey() {
//        return Keys.hmacShaKeyFor(secretKey.getBytes());
//    }
//
//    public String generateToken(LoginDto user) {
//      return   Jwts.builder()
//             //   .subject(String.valueOf(user.getId()))
//                .claim("email", user.getEmail())
//              //  .claim("username", user.getName())
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + 1000*60))
//                .signWith(getSecretKey())
//                .compact();
//
//    }
//    public int getUserIdFromToken(String token) {
//        Claims claims = Jwts.parser()
//                .verifyWith(getSecretKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//        return Integer.parseInt(claims.getSubject());
//    }
//}
