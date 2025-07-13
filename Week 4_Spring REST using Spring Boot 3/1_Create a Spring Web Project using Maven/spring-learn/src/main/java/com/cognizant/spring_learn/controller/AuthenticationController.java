package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    @RequestMapping("/authenticate")
    public Map<String, String> authenticate(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String base64Credentials = authHeader.substring("Basic ".length());
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes);
            String[] values = credentials.split(":", 2);

            String username = values[0];
            String password = values[1];

            if (username.equals("user") && password.equals("pwd")) {
                // 🔥 Generate real JWT token here
                String token = Jwts.builder()
                        .setSubject(username)
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))  // 1 hour expiry
                        .signWith(SignatureAlgorithm.HS256, "secretkey")
                        .compact();

                Map<String, String> response = new HashMap<>();
                response.put("token", token);
                return response;
            }
        }

        throw new RuntimeException("Invalid credentials");
    }
}
