package com.cadastro.dados;

import com.cadastro.dados.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DadosApplication {

    private final HelloController helloController;

    DadosApplication(HelloController helloController) {
        this.helloController = helloController;
    }

	public static void main(String[] args) {
		SpringApplication.run(DadosApplication.class, args);

		
	}

}
