package com.example.UserDataApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class UserDataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDataApiApplication.class, args);
	}

}
