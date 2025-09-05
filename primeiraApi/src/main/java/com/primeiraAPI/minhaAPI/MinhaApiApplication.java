package com.primeiraAPI.minhaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController

public class MinhaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinhaApiApplication.class, args);
	}	

}
