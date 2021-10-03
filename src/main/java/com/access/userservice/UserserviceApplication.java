package com.access.userservice;

import com.access.userservice.domain.Role;
import com.access.userservice.domain.User;
import com.access.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Feli", "feli", "1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Alex", "alex", "1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Alef", "alef", "1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Bobs", "bobs", "1234",new ArrayList<>()));

			userService.addRoleToUser("feli","ROLE_USER");
			userService.addRoleToUser("alex","ROLE_USER");
			userService.addRoleToUser("alex","ROLE_MANAGER");
			userService.addRoleToUser("alef","ROLE_ADMIN");
			userService.addRoleToUser("bobs","ROLE_SUPER_ADMIN");

		};
	}

}
