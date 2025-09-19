package com.cadastro.dados.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cadastro.dados.model.Department;
import com.cadastro.dados.repositorie.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    // Buscar todos os departamentos
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    // Buscar um departamento por ID
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    // Salvar ou atualizar um departamento
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    // Deletar um departamento por ID
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
}
