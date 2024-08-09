package com.example.AuthApplication.service;

import com.example.AuthApplication.domain.User;

import java.util.Map;

public interface SecurityTokenGenrator {
    Map<String,String> generateToken(User user);
}
