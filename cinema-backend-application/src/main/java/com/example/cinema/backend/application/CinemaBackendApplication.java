package com.example.cinema.backend.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.cinema.backend.application.*")
@EntityScan("com.example.cinema.backend.application.*")
@EnableJpaRepositories()

public class CinemaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaBackendApplication.class, args);
	}

}
