package com.example.DTO.s.security;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

import java.security.SecureRandom;

//import javax.annotation.PostConstruct;

@Component
public class SecureRandomInitializer {

    @PostConstruct
    public void init() {
        // Initialize SecureRandom to avoid delay during first use
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextInt(); // Initialize the SecureRandom instance
    }
}
