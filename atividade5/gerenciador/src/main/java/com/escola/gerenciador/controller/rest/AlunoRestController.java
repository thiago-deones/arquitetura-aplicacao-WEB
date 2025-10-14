package com.escola.gerenciador.controller.rest;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.gerenciador.service.AlunoService;
import com.escola.gerenciador.service.CursoService;

@RestController
@RequestMapping("/api/alunos")
public class AlunoRestController {

    private final CursoService cursoService;
    private final AlunoService service;

    public AlunoRestController(AlunoService service, CursoService cursoService){
        this.service = service;
        this.cursoService = cursoService;
    }

    // Save an Aluno
    @PostMapping
    public ResponseEntity<?> createAluno(@RequestBody Aluno aluno){
        if (aluno.getCurso() != null && aluno.getCurso().getId() != null) {
            
        }
    }
}
