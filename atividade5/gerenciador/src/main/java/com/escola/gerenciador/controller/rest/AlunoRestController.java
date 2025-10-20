package com.escola.gerenciador.controller.rest;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.gerenciador.model.Aluno;
import com.escola.gerenciador.model.Curso;
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
            Curso curso = cursoService.findById(curso.getCurso().getId());
            if (curso != null) {
                aluno.setCurso(curso);
                Aluno savedAluno = service.save(aluno);
                return ResponseEntity.status(Response.SC_CREATED).body(savedAluno);
            } else {
                return ResponseEntity.status(Response.SC_BAD_REQUEST)
                        .body("Curso com ID " + aluno.getCurso().getId() + " não encontrado.");
            }
        }
    }

    @GetMapping
    public List<Aluno> getAllAlunos(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Long id){
        Aluno aluno = service.findById(id);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
}
