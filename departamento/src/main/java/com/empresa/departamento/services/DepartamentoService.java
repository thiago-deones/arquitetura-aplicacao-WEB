package com.empresa.departamento.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.departamento.model.Departamento;
import com.empresa.departamento.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

    private final DepartamentoRepository repo;

    //Injeção de dependência via contrutor
    public DepartamentoService(DepartamentoRepository repo){
        this.repo = repo;
    }
    //salvar departamento
    public Departamento save(Departamento  departamento){
        return repo.save(departamento);
    }
    //buscar departaemnto por id
    public Departamento findById(Long id){
        return repo.findById(id).orElse(null);
    }
    //mostrar todos os departamentos 
    public List<Departamento> findAll(){
        return repo.findAll();
    }
    //deletar departamento
    public Boolean deleteById(Long id){
        if(findById(id) == null){
            return false;
        } else{
            repo.deleteById(id);
            return true;
        }
    } 



}
