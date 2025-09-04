package com.primeiraAPI.minhaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.controller.HelloController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController

public class MinhaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinhaApiApplication.class, args);
	}	

}
