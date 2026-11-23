package com.curriculum.m4p3;

import java.util.*;

/**
 * Naive Service that depends on persistence-specific details (DbResultSet).
 */
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        System.out.println("[Service] Converting raw DB results to Domain objects...");
        List<Product> products = new ArrayList<>();
        
        // LEAK: The service is forced to deal with DbResultSet
        ProductRepository.DbResultSet rs = repository.getAllProducts();
        
        while (rs.next()) {
            int id = (int) rs.getValue("id");
            String name = (String) rs.getValue("name");
            double price = (double) rs.getValue("price");
            
            products.add(new Product(id, name, price));
            rs.advance();
        }
        
        return products;
    }
}
