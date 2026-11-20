package com.curriculum.m4p17;

import java.util.*;
import java.util.stream.Collectors;

public class PostRepository {
    private List<Post> mockDb = Arrays.asList(
        new Post(1, 1, "Alice's First Post"),
        new Post(2, 1, "Alice's Second Post"),
        new Post(3, 2, "Bob's Only Post"),
        new Post(4, 3, "Charlie's First Post"),
        new Post(5, 3, "Charlie's Second Post"),
        new Post(6, 3, "Charlie's Third Post")
    );

    public List<Post> getPostsByUserId(int userId) {
        System.out.println("Executing: SELECT * FROM posts WHERE user_id = " + userId);
        return mockDb.stream()
            .filter(p -> p.getUserId() == userId)
            .collect(Collectors.toList());
    }
}
