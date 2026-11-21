package com.curriculum.m4p3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        ProductService service = new ProductService(repository);
        
        List<Product> products = service.getAllProducts();
        
        System.out.println("\n--- Product List (Fixed) ---");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
