package com.escola.gerenciador.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.escola.gerenciador.model.Curso;
import com.escola.gerenciador.repository.CursoRepository;

@Service
public class CursoService {

    private final CursoRepository repo;

    // Construtor para injeção de dependência
    public CursoService(CursoRepository repo){
        this.repo = repo;
    }
    // Mostrar todos os cursos
    public List<Curso> findAll(){
        return repo.findAll();
    }
    // Salvar um curso
    public Curso save(Curso curso){
        return repo.save(curso);
    }
    // Buscar um curso pelo ID
    public Curso findById(Long id){
        return repo.findById(id).orElse(null);
    }
    // Deletar um curso pelo Id
    public Boolean deleteByid(Long id){
        if (findById(id)!= null){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
