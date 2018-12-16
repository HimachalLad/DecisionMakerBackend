package com.example.projectDM.security;

import org.springframework.stereotype.Component;
import com.example.projectDM.entity.Login;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {
	 private String secret = "secretKey"; 
	 
	    public Login validate(String token) {

	        Login loginUser = null;
	        try {
	            Claims body = Jwts.parser()
	                    .setSigningKey(secret)
	                    .parseClaimsJws(token)
	                    .getBody();

	            loginUser = new Login();

	            loginUser.setName(body.getSubject());
	            loginUser.setId(Long.parseLong((String) body.get("userId")));
	            loginUser.setEmail((String) body.get("email"));
	        }
	        catch (Exception e) {
	            System.out.println(e);
	        }

	        return loginUser;
	    }
}
