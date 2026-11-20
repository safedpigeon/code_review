package com.curriculum.singleton;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.createUser("JohnDoe");
        userService.createUser("JaneDoe");
    }
}
