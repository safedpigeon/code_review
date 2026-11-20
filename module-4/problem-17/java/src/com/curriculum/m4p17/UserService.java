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
        
        // Collect all user IDs to avoid N+1
        List<Integer> userIds = new ArrayList<>();
        for (User user : users) {
            userIds.add(user.getId());
        }
        
        // Bulk fetch posts for all users
        List<Post> allPosts = postRepo.getPostsByUserIds(userIds);
        
        // Group posts by user ID
        Map<Integer, List<Post>> postsByUser = new HashMap<>();
        for (Post post : allPosts) {
            postsByUser.computeIfAbsent(post.getUserId(), k -> new ArrayList<>()).add(post);
        }
        
        List<Map<String, Object>> result = new ArrayList<>();
        for (User user : users) {
            Map<String, Object> entry = new HashMap<>();
            entry.put("user", user.getName());
            
            List<Post> posts = postsByUser.getOrDefault(user.getId(), Collections.emptyList());
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
