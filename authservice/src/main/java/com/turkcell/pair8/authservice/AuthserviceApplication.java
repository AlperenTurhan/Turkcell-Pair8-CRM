package com.turkcell.pair8.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@Import({JwtService.class, UserServiceImpl.class, UserRepository.class})
@ComponentScan(basePackages = "com.pair4")
@EntityScan(basePackages = "com.pair4.entities")
@EnableJpaRepositories(basePackages = {"com.pair4.repositories"})
public class AuthserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthserviceApplication.class, args);
	}

}
