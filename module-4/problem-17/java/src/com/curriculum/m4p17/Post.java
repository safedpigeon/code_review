package com.curriculum.m4p17;

public class Post {
    private int id;
    private int userId;
    private String title;

    public Post(int id, int userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getTitle() { return title; }
}
