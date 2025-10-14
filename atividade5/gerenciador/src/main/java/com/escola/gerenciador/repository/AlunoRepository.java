package com.escola.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.gerenciador.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long>{
}
