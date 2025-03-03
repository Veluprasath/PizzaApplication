package com.example.AuthApplication.service;

import com.example.AuthApplication.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGenratorImpl implements SecurityTokenGenrator{
    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken = null;
        jwtToken = Jwts.builder()
                .setSubject(user.getEmailId())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"secretkey").compact();

        Map<String,String> map = new HashMap<>();
        map.put("token",jwtToken);
        map.put("emailId", user.getEmailId());
        map.put("role", user.getRole());
//        map.put("status", user.getStatus());
        map.put("message", "User Successfully Logged In !");
        return map;
    }
}
