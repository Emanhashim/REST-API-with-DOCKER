package com.example.DTO.s.model;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class MyUserDetails extends User {

    // Custom fields and constructor
    public MyUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    // You can add custom methods to handle additional properties if necessary
}
