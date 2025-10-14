package com.escola.gerenciador.controller.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.escola.gerenciador.model.Curso;
import com.escola.gerenciador.service.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoRestController {
    private final CursoService service;

    public CursoRestController(CursoService service) {
        this.service = service;
    }   

    // Create a new Curso
    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso){
        return ResponseEntity.ok(service.save(curso));
    }
    // Get all Cursos
    @GetMapping
    public List<Curso> allCursos(){
        return service.findAll();
    }
    // Get a Curso by ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id){
        Curso curso = service.findById(id);
        if (curso != null) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Delete a Curso by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id){
        if (service.deleteByid(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Update a Curso by ID
    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso cursoDetails){
        Curso curso = service.findById(id);
        if (curso != null) {
            curso.setNome(cursoDetails.getNome());
            curso.setCargaHoraria(cursoDetails.getCargaHoraria());
            return ResponseEntity.ok(service.save(curso));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
