package com.example.DTO.s.dto;

import lombok.Data;

@Data
public class UserLocation {

    private long UserId;
    private String email;
    private String place;
    private double longitude;
    private double latitude;

}
