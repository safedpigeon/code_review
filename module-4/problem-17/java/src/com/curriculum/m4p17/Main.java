package com.curriculum.m4p17;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepo = new UserRepository();
        PostRepository postRepo = new PostRepository();
        UserService userService = new UserService(userRepo, postRepo);

        System.out.println("Fetching users and their posts...");
        List<Map<String, Object>> data = userService.getUsersWithPosts();
        
        for (Map<String, Object> entry : data) {
            System.out.println("User: " + entry.get("user") + ", Posts: " + entry.get("posts"));
        }
    }
}
