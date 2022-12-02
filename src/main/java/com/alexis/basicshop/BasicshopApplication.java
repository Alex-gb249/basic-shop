package com.alexis.basicshop;

import com.alexis.basicshop.models.Role;
import com.alexis.basicshop.models.User;
import com.alexis.basicshop.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class BasicshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicshopApplication.class, args);
	}

	/*@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Alexis", "alexis123", "123456", new ArrayList<>(), null));
			userService.saveUser(new User(null, "Bryan", "bryan123", "123456", new ArrayList<>(), null));
			userService.saveUser(new User(null, "Juan Diego", "juandi123", "123456", new ArrayList<>(), null));
			userService.saveUser(new User(null, "Miguel", "miguel123", "123456", new ArrayList<>(), null));

			userService.addRoleToUser("alexis123", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("alexis123", "ROLE_USER");
			userService.addRoleToUser("alexis123", "ROLE_ADMIN");
			userService.addRoleToUser("bryan123", "ROLE_ADMIN");
			userService.addRoleToUser("juandi123", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("miguel123", "ROLE_SUPER_ADMIN");

		};
	}*/

}
