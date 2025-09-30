package com.remedios.thiago.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.remedios.thiago.Remedio;
import com.remedios.thiago.remedio.DadosCadastroRemedios;
import com.remedios.thiago.remedio.RemedioRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/remedios")
public class RemedioController {
    
    @Autowired
    private RemedioRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedios dados) {
        repository.save(new Remedio(dados));       
    }
}
