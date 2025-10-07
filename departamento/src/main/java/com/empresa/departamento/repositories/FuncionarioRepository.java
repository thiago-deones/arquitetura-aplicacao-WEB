package com.empresa.departamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.departamento.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
