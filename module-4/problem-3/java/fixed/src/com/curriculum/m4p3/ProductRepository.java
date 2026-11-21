package com.curriculum.m4p3;

import java.util.*;

/**
 * Fixed Implementation: Repository returns Domain objects.
 */
public class ProductRepository {
    public List<Product> getAllProducts() {
        System.out.println("[Repo] Fetching and mapping data to Domain objects...");
        
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 1200.0));
        products.add(new Product(2, "Mouse", 25.0));
        products.add(new Product(3, "Keyboard", 75.0));
        
        return products;
    }
}
