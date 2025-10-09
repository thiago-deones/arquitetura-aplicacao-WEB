package com.cadastro.dados.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cadastro.dados.services.HelloServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {

    @Autowired
    private HelloServices helloServices;

    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "World" ) String name) {
        return String.format("Hello %s!", name);
    }
    
}
