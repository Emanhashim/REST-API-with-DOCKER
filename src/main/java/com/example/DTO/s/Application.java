package com.example.DTO.s;

import com.example.DTO.s.model.Location;
import com.example.DTO.s.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.example.DTO.s.repository.LocationRepository;
import com.example.DTO.s.repository.UserRepository;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example.DTO.s.repository")
//@EntityScan(basePackages = "com.example.DTO.s.model")

public class Application  {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
