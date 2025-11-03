package com.escola.gerenciador.controller.rest;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
            Curso Existecurso = cursoService.findById(aluno.getCurso().getId());
            if (Existecurso != null) {
                aluno.setCurso(Existecurso);
                Aluno savedAluno = service.save(aluno);
                return ResponseEntity.status(Response.SC_CREATED).body(savedAluno);
            } else {
                return ResponseEntity.status(Response.SC_BAD_REQUEST)
                        .body("Curso com ID " + aluno.getCurso().getId() + " não encontrado.");
            }
        }
        return null;
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

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno alunoDetails){
        Aluno aluno = service.findById(id);
        if (aluno != null) {
            aluno.setNome(alunoDetails.getNome());
            aluno.setEmail(alunoDetails.getEmail());
            aluno.setDataNascimento(alunoDetails.getDataNascimento());
            if (alunoDetails.getCurso() != null && alunoDetails.getCurso().getId() != null) {
                Curso curso = cursoService.findById(alunoDetails.getCurso().getId());
                if (curso != null) {
                    aluno.setCurso(curso);
                } else {
                    return ResponseEntity.badRequest().build();
                }
            }
            return ResponseEntity.ok(service.save(aluno));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id){
        boolean deleted = service.deleteById(id);
        if (deleted){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    
}
