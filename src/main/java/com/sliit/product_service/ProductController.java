package com.sliit.product_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // 1. POST endpoint to create a product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // 2. GET endpoint to retrieve all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 3. GET by ID endpoint
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    // 4. DELETE endpoint
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}