package com.remedios.thiago.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HElloWorld {
    
    @GetMapping
    public String olaMund() {
        return "Hello world!";
    }
}
