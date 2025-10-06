package br.com.empresa.vendamais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.vendamais.model.Produto;
import br.com.empresa.vendamais.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> produtos =produtoService.findAll();
        return ResponseEntity.ok().body(produtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok().body(produto);
    }
    @PostMapping("/inserir")
    public ResponseEntity<Produto> insertNew(@RequestBody Produto produto){
        Produto produtoInserido = produtoService.insertNew(produto);
        return ResponseEntity.ok().body(produtoInserido);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Produto> upDate(@PathVariable Long id, @RequestBody Produto produtoAlterado) {
        Produto produto = produtoService.upDate(id, produtoAlterado);
        return ResponseEntity.ok().body(produto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletaById(@PathVariable Long id){
        Boolean flag = produtoService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
}
