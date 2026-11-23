package com.curriculum.m4p3;

import java.util.*;

/**
 * Naive Implementation of a Repository that leaks persistence details.
 * It returns a DbResultSet instead of a Domain Model (Product).
 */
public class ProductRepository {
    
    // This class represents a database-specific result set (The Leak)
    public static class DbResultSet {
        private List<Map<String, Object>> rows;
        private int cursor = 0;

        public DbResultSet(List<Map<String, Object>> rows) {
            this.rows = rows;
        }

        public boolean next() {
            return cursor < rows.size();
        }

        public Object getValue(String column) {
            return rows.get(cursor).get(column);
        }

        public void advance() {
            cursor++;
        }
    }

    public DbResultSet getAllProducts() {
        System.out.println("[Repo] Fetching raw data from database...");
        
        List<Map<String, Object>> data = new ArrayList<>();
        data.add(Map.of("id", 1, "name", "Laptop", "price", 1200.0));
        data.add(Map.of("id", 2, "name", "Mouse", "price", 25.0));
        data.add(Map.of("id", 3, "name", "Keyboard", "price", 75.0));
        
        return new DbResultSet(data);
    }
}
