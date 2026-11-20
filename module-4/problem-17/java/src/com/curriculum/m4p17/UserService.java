package com.curriculum.m4p17;

import java.util.*;

public class UserService {
    private UserRepository userRepo;
    private PostRepository postRepo;

    public UserService(UserRepository userRepo, PostRepository postRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    public List<Map<String, Object>> getUsersWithPosts() {
        List<User> users = userRepo.getAllUsers();
        List<Map<String, Object>> result = new ArrayList<>();
        
        for (User user : users) {
            List<Post> posts = postRepo.getPostsByUserId(user.getId());
            Map<String, Object> entry = new HashMap<>();
            entry.put("user", user.getName());
            
            List<String> postTitles = new ArrayList<>();
            for (Post p : posts) {
                postTitles.add(p.getTitle());
            }
            entry.put("posts", postTitles);
            result.add(entry);
        }
        return result;
    }
}
