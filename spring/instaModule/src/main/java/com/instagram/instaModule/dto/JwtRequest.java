package com.instagram.instaModule.dto;

import com.instagram.instaModule.filter.JwtAuthFilter;
import com.instagram.instaModule.service.JwtService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class JwtRequest {
    private String token;
    public JwtRequest(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
}
