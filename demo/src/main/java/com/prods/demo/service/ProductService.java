package com.prods.demo.service;

import com.prods.demo.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    // GET todos
    public List<Product> getAllProducts() {
        return products;
    }

    // GET por ID
    public Optional<Product> getProductById(Long id) {
        return products.stream()
                       .filter(p -> p.getId().equals(id))
                       .findFirst();
    }

    // POST adicionar
    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    // PUT atualizar
    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        return getProductById(id).map(existing -> {
            existing.setName(updatedProduct.getName());
            return existing;
        });
    }

    // DELETE remover
    public boolean deleteProduct(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}
