package com.example.projectDM.security;

import org.springframework.stereotype.Component;

import com.example.projectDM.entity.Login;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {
	public String generate(Login loginUser) {


        Claims claims = Jwts.claims()
                .setSubject(loginUser.getName());
        claims.put("userId", String.valueOf(loginUser.getId()));
        claims.put("role", "");
        claims.put("email", loginUser.getEmail());
        

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "secretKey")
                .compact();
    }
}
