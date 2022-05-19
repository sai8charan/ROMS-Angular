package com.authorization;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.authorization.model.User;
import com.authorization.repo.UserRepo;

@SpringBootApplication
public class AuthorizationApplication {
	@Autowired
	private UserRepo repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}

	@PostConstruct
	
	public void initUsers() {
		List<User> users =Stream.of(new User("ram", passwordEncoder.encode("ram@123"), "ROLE_USER"),
				new User("kiran", passwordEncoder.encode("kiran@123"), "ROLE_USER"),
				new User("rahul", passwordEncoder.encode("rahul@123"), "ROLE_USER")).collect(Collectors.toList());
		repo.saveAll(users);
		
	}
}
