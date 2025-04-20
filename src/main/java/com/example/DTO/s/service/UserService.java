package com.example.DTO.s.service;

import com.example.DTO.s.dto.UserLocation;
import com.example.DTO.s.dto.UserRequestDto;
import com.example.DTO.s.model.Location;
import com.example.DTO.s.model.User;
import com.example.DTO.s.repository.LocationRepository;
import com.example.DTO.s.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ModelMapper modelMapper;  // Ensure this is properly injected

    // Get all users with their location
    public List<UserLocation> getAllUsersLocation() {
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    // Convert User entity to UserLocation DTO
    private UserLocation convertEntityToDto(User user) {
        UserLocation userLocation = modelMapper.map(user, UserLocation.class);
        userLocation.setPlace(user.getLocation().getPlace());
        userLocation.setLongitude(user.getLocation().getLongitude());
        userLocation.setLatitude(user.getLocation().getLatitude());
        return userLocation;
    }

    // Create a new User along with Location
    public UserLocation createUser(UserRequestDto request) {
        // Create and save Location entity
        Location location = new Location();
        location.setPlace(request.getPlace());
        location.setDescription(request.getDescription());
        location.setLatitude(request.getLatitude());
        location.setLongitude(request.getLongitude());
        locationRepository.save(location);

        // Map UserRequestDto to User entity using ModelMapper
        User user = modelMapper.map(request, User.class);
        user.setLocation(location);  // Associate the location with the user
        userRepository.save(user);

        // Map the saved User entity to UserLocation DTO and return it
        return modelMapper.map(user, UserLocation.class);
    }

    // Optional: Method to find user by ID and return UserLocation
    public UserLocation getUserLocation(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserLocation.class);
    }
}
