package com.brian.springsecuritywithjsonwebtoken;

import com.brian.springsecuritywithjsonwebtoken.model.Role;
import com.brian.springsecuritywithjsonwebtoken.model.User;
import com.brian.springsecuritywithjsonwebtoken.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityWithJsonWebTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithJsonWebTokenApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"Thinh Le", "thinhl","1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Nhat Le", "nhatl","1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Vu Nguyen", "vung","1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Duy Nguyen", "duyng","1234", new ArrayList<>()));

			userService.addRoleToUser("thinhl", "ROLE_USER");
			userService.addRoleToUser("thinhl", "ROLE_MANAGER");
			userService.addRoleToUser("nhatl", "ROLE_MANAGER");
			userService.addRoleToUser("vung", "ROLE_USER");
			userService.addRoleToUser("vung", "ROLE_MANAGER");
			userService.addRoleToUser("vung", "ROLE_ADMIN");
			userService.addRoleToUser("duyng", "ROLE_SUPER_ADMIN");
		};
	}
}
