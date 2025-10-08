package com.empresa.departamento.controller.rest;

import com.empresa.departamento.model.Departamento;
import com.empresa.departamento.services.DepartamentoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoRestController {
    private final DepartamentoService service;
    
    public DepartamentoRestController(DepartamentoService service) {
         this.service = service;
    }

    @PostMapping
    public ResponseEntity<Departamento> create(@RequestBody Departamento departamento){
        return ResponseEntity.status(201).body(service.save(departamento));
    }

    @GetMapping
    public List<Departamento> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getById(@PathVariable Long id){
        Departamento departamento = service.findById(id);
        return departamento != null ? 
                ResponseEntity.ok(departamento) : 
                ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> update(@PathVariable Long id, @RequestBody Departamento departamento){
        Departamento existingDepartamento = service.findById(id);
        if (existingDepartamento == null) {
            return ResponseEntity.notFound().build();
        }else{
            existingDepartamento.setNome(departamento.getNome());
            existingDepartamento.setLocalizacao(departamento.getLocalizacao());
            return ResponseEntity.ok(service.save(existingDepartamento));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (service.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
