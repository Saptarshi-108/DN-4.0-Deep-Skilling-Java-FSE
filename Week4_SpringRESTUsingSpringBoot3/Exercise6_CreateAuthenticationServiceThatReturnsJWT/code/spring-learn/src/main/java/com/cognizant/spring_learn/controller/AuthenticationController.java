package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    
    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start");
        LOGGER.debug("Authorization header: {}", authHeader);
        
        Map<String, String> map = new HashMap<>();
        
        String user = getUser(authHeader);
        String token = generateJwt(user);
        
        map.put("token", token);
        
        LOGGER.info("End");
        return map;
    }
    
    private String getUser(String authHeader) {
        LOGGER.debug("getUser - Start");
        
        // Remove "Basic " prefix
        String encodedCredentials = authHeader.substring("Basic ".length());
        LOGGER.debug("Encoded credentials: {}", encodedCredentials);
        
        // Decode the Base64 encoded credentials
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);
        LOGGER.debug("Decoded credentials: {}", credentials);
        
        // Extract username (text before colon)
        String user = credentials.split(":")[0];
        LOGGER.debug("Extracted user: {}", user);
        
        LOGGER.debug("getUser - End");
        return user;
    }
    
    private String generateJwt(String user) {
        LOGGER.debug("generateJwt - Start");
        LOGGER.debug("Generating JWT for user: {}", user);

        // Use a secure key of at least 32 bytes
        Key key = Keys.hmacShaKeyFor("my-super-secret-key-for-jwt-signing-should-be-32-bytes!".getBytes());

        String token = Jwts.builder()
            .setSubject(user)
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + 1200000))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();

        LOGGER.debug("Generated token: {}", token);
        LOGGER.debug("generateJwt - End");

        return token;
    }
}
