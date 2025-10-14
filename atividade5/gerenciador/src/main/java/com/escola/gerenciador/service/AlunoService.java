package com.escola.gerenciador.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.escola.gerenciador.model.Aluno;
import com.escola.gerenciador.repository.AlunoRepository;


@Service
public class AlunoService {

    private final AlunoRepository repo;

    // Construtor para injeção de dependência
    public AlunoService(AlunoRepository repo){
        this.repo = repo;
    }
    //Salvar um aluno
    public Aluno save(Aluno aluno){
        return repo.save(aluno);
    }
    //Buscar um aluno pelo ID
    public Aluno findById(Long id){
        return repo.findById(id).orElse(null);
    }
    //mostrar todos os alunos
    public List<Aluno> findAll(){
        return repo.findAll();
    }
    //Deletar um aluno pelo Id
    public Boolean deleteById(Long id){
        if(findById(id)!=null){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
    
}
