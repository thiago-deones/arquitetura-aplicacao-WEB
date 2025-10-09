package com.cadastro.dados.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastro.dados.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
