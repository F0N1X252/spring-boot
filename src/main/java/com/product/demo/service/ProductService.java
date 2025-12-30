package com.product.demo.service;

import com.product.demo.dto.ProductRequestDTO;
import com.product.demo.entity.Product;
import com.product.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    // Constructor Injection
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(ProductRequestDTO request) {
        Product product = new Product();
        product.setName(request.name());
        product.setCategory(request.category());
        product.setPrice(request.price());
        product.setStock(request.stock());
        return repository.save(product);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produk dengan ID " + id + " tidak ditemukan"));
    }

    public Product update(Long id, ProductRequestDTO request) {
        Product product = getById(id);
        product.setName(request.name());
        product.setCategory(request.category());
        product.setPrice(request.price());
        product.setStock(request.stock());
        return repository.save(product);
    }

    public void delete(Long id) {
        Product product = getById(id);
        repository.delete(product);
    }
}