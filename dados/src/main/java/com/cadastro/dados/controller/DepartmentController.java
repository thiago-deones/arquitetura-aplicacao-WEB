package com.cadastro.dados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cadastro.dados.model.Department;
import com.cadastro.dados.services.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    // GET /departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.findAll();
    }

    // GET /departments/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentService.findById(id);
        return department.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /departments
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

    // PUT /departments/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
        Optional<Department> departmentOptional = departmentService.findById(id);
        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            department.setTitle(departmentDetails.getTitle()); // ajuste o campo conforme seu modelo
            return ResponseEntity.ok(departmentService.save(department));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /departments/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
