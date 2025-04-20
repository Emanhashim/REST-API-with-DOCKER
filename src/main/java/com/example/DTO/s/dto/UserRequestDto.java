package com.example.DTO.s.dto;


import lombok.Data;

@Data
public class UserRequestDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String place;
    private String description;
    private double latitude;
    private double longitude;
}
