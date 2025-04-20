package com.example.DTO.s.ModelMapper;

import com.example.DTO.s.dto.UserLocation;
import com.example.DTO.s.model.User;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {

    private final ModelMapper modelMapper = new ModelMapper(); // ✅ Create a single instance

    @Bean
    public ModelMapper modelMapper() {
        return modelMapper; // ✅ Return the field, not recursively call the method
    }

    @PostConstruct
    public void setupMappings() {
        // Entity → DTO mapping
        modelMapper.typeMap(User.class, UserLocation.class).addMappings(mapper -> {
            mapper.map(src -> src.getLocation().getPlace(), UserLocation::setPlace);
            mapper.map(src -> src.getLocation().getLongitude(), UserLocation::setLongitude);
            mapper.map(src -> src.getLocation().getLatitude(), UserLocation::setLatitude);
        });

        // DTO → Entity mapping (optional)
        modelMapper.typeMap(UserLocation.class, User.class).addMappings(mapper -> {
            mapper.skip(User::setId); // skip auto-generated ID
            mapper.map(UserLocation::getEmail, User::setEmail);
        });
    }
}
