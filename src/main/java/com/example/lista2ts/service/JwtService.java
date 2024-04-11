package com.example.lista2ts.service;

import com.example.lista2ts.entity.AuthEntity;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JwtService {
    public String generateToken(AuthEntity userDetail){
        return null;
    }

    public boolean isTokenValid(String token) {
        verify(token);
        isTokenExpired(token);
        return true;
    }

    public boolean isTokenExpired(String token) {
        return false;
    }

    public boolean verify(String token) {
        return true;
    }

    private String generateToken(Map<String, Object> extraClaims, AuthEntity userDetails) {
    }

}
