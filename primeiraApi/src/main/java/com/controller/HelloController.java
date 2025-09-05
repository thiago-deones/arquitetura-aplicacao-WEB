package com.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {

    @GetMapping("/call-hello")

    public String getMethodName(@RequestParam (value = "name", defaultValue = "World") String name) {
        return String.format("Hello, Thiago " + name + "!");
    }
    
}
