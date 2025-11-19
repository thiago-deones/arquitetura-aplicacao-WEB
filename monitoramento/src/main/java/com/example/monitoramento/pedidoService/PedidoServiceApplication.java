package com.example.monitoramento.pedidoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "com.example.monitoramento.pedidoService",
    "com.example.monitoramento.controller",
    "com.example.monitoramento.service",
    "com.example.monitoramento.metrics"
})
public class PedidoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PedidoServiceApplication.class, args);
    }
}
