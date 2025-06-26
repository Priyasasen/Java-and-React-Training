package com.hexaware.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.bms.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    static class LoginRequest {
        public String username;
        public String password;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        if ("admin".equals(loginRequest.username) && "admin123".equals(loginRequest.password)) {
            return jwtUtil.generateToken(loginRequest.username);
        }
        throw new RuntimeException("Invalid credentials");
    }
}