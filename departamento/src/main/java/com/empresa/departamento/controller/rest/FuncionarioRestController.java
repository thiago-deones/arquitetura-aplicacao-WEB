package com.empresa.departamento.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.departamento.model.Departamento;
import com.empresa.departamento.model.Funcionario;
import com.empresa.departamento.services.DepartamentoService;
import com.empresa.departamento.services.FuncionarioService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioRestController {

    private final FuncionarioService service;
    private final DepartamentoService deptService;

    public FuncionarioRestController(FuncionarioService service, DepartamentoService deptService){
        this.service = service;
        this.deptService = deptService;
    }

    // Métodos CRUD para Funcionario podem ser adicionados aqui
    //Post
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Funcionario funcionario) {
        if (funcionario.getDepartamento() != null && funcionario.getDepartamento().getId() != null) {
            Departamento departamento = deptService.findById(funcionario.getDepartamento().getId());
            if (departamento == null) {
                return ResponseEntity.badRequest().body("Departamento com ID " + funcionario.getDepartamento().getId() + " não encontrado.");
            }
            funcionario.setDepartamento(departamento);
        }
        
        return ResponseEntity.status(201).body(service.save(funcionario));
    }

    @GetMapping
    public List<Funcionario> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getById(@PathVariable Long id){
        Funcionario funcionario = service.findByid(id);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.notFound().build();
    }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody Funcionario funcionarioDetails) {
        Funcionario funcionario = service.findByid(id);
        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        }

        funcionario.setNome(funcionarioDetails.getNome());
        funcionario.setEmail(funcionarioDetails.getEmail());
        funcionario.setDataAdmissao(funcionarioDetails.getDataAdmissao());

        if (funcionarioDetails.getDepartamento() != null && funcionarioDetails.getDepartamento().getId() != null) {
            Departamento departamento = deptService.findById(funcionarioDetails.getDepartamento().getId());
            if (departamento == null) {
                return ResponseEntity.badRequest().body(null);
            }
            funcionario.setDepartamento(departamento);
        } else {
            funcionario.setDepartamento(null);
        }

        Funcionario updatedFuncionario = service.save(funcionario);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
