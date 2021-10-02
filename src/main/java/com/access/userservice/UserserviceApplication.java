package com.access.userservice;

import com.access.userservice.domain.Role;
import com.access.userservice.domain.User;
import com.access.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Felipe", "felipe", "1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Arnold Schawrzenegger", "arnold", "1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Will Smith", "lenda", "1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Jim Carry", "jim", "1234",new ArrayList<>()));

			userService.addRoleToUser("felipe","ROLE_USER");
			userService.addRoleToUser("arnold","ROLE_MANAGER");
			userService.addRoleToUser("lenda","ROLE_MANAGER");
			userService.addRoleToUser("lenda","ROLE_ADMIN");
			userService.addRoleToUser("jim","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("jim","ROLE_ADMIN");
			userService.addRoleToUser("jim","ROLE_USER");

		};
	}

}
