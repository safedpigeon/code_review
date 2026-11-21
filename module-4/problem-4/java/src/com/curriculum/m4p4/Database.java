package com.curriculum.m4p4;

import java.util.*;

public class Database {
    private static Database instance;
    public Map<String, Integer> inventory = new HashMap<>();
    public List<String> orders = new ArrayList<>();

    private Database() {
        inventory.put("PROD1", 10);
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
