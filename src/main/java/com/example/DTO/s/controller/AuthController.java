package com.example.DTO.s.controller;

import com.example.DTO.s.security.JwtUtil;
import com.example.DTO.s.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        // Authenticate and generate token (simplified)
        return jwtUtil.generateToken(authRequest.getEmail());
    }
}
