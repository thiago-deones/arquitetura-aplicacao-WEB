package com.empresa.departamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.departamento.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    
} 
