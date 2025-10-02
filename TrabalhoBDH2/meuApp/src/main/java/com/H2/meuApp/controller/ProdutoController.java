package com.H2.meuApp.controller;



import com.H2.meuApp.model.Produto;
import com.H2.meuApp.repository.ProdutoRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    // Listar todos os produtos
    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    // Adicionar um novo produto
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

@GetMapping("/{id}")
public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
    return repository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deletar(@PathVariable Long id) {
    if (repository.existsById(id)) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build(); 
    } else {
        return ResponseEntity.notFound().build(); 
    }
}

@PutMapping("/{id}")
public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto novoProduto) {
    return repository.findById(id)
            .map(produto -> {
                produto.setNome(novoProduto.getNome());
                produto.setPreco(novoProduto.getPreco());
                repository.save(produto);
                return ResponseEntity.ok(produto);
            })
            .orElse(ResponseEntity.notFound().build());
}


}
