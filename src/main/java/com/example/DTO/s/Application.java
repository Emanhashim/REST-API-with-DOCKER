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

//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private LocationRepository locationRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		Location location = new Location();
//		location.setPlace( "newyork");
//		location.setDescription("noce view");
//		location.setLongitude(30.8);
//		location.setLatitude(78.0);
//		locationRepository.save(location);
//
//
//
//		User user = new User();
//		user.setEmail("userq@gmail.com");
//		user.setPassword("secret");
//		user.setFirstName("eman");
//		user.setLastName("hannan");
//		user.setLocation(location);
//		userRepository.save(user);
//
//
//		User user2 = new User();
//		user2.setEmail("user2@gmail.com");
//		user2.setPassword("secretuser");
//		user2.setFirstName("lemi");
//		user2.setLastName("harpa");
//		user2.setLocation(location);
//		userRepository.save(user2);
//	}
}
