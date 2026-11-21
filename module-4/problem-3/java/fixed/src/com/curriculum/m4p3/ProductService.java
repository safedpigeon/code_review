package com.curriculum.m4p3;

import java.util.*;

/**
 * Fixed Service: No longer depends on persistence details.
 */
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        // No more mapping here! The repository handles it.
        return repository.getAllProducts();
    }
}
