package com.empresa.departamento.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.departamento.model.Funcionario;
import com.empresa.departamento.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    private final FuncionarioRepository repo;

    public FuncionarioService(FuncionarioRepository repo) {
        this.repo = repo;
    }

    //Injetar um novo funcionário
    public Funcionario save(Funcionario funcionario){
        return repo.save(funcionario);
    }
    //Buscar todos os funcionários
    public List<Funcionario> findAll(){
        return repo.findAll();
    }
    //Buscar funcionário por ID
    public Funcionario findByid(Long id){
        return repo.findById(id).orElse(null);
    }
    //Deletar funcionário por ID
    public Boolean deleteById(Long id){
        if (findByid(id) == null){
            return false;
        }else{
            repo.deleteById(id);
            return true;   
        }
    }
}
