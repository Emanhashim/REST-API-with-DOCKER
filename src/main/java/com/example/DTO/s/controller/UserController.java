package com.example.DTO.s.controller;

import com.example.DTO.s.dto.UserLocation;
import com.example.DTO.s.dto.UserRequestDto;
import com.example.DTO.s.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users and their location details
    @GetMapping("/location")
    public List<UserLocation> getAllUsersLocation() {
        return userService.getAllUsersLocation();
    }

    // Create a new user along with their location
    @PostMapping("data")
    public ResponseEntity<String> createUser(@RequestBody UserRequestDto userDto) {
        UserLocation createdUserLocation = userService.createUser(userDto);
        if (createdUserLocation != null) {
            return ResponseEntity.ok("User created successfully");
        } else {
            return ResponseEntity.status(500).body("Failed to create user");
        }
    }

    // Optional: Get a user by their ID along with location details
    @GetMapping("/{id}/location")
    public ResponseEntity<UserLocation> getUserLocation(@PathVariable Long id) {
        UserLocation userLocation = userService.getUserLocation(id);
        if (userLocation != null) {
            return ResponseEntity.ok(userLocation);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
