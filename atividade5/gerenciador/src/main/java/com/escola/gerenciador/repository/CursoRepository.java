package com.escola.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.gerenciador.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
}
