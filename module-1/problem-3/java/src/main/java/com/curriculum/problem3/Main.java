package com.curriculum.problem3;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        System.out.println("Fetching existing user:");
        User user1 = userService.getUser("1");
        System.out.println("Found: " + (user1 != null ? user1.getName() : "null"));

        System.out.println("\nFetching non-existent user:");
        User user2 = userService.getUser("3");
        System.out.println("Found: " + (user2 != null ? user2.getName() : "null"));

        System.out.println("\nFetching with null ID:");
        User user3 = userService.getUser(null);
        System.out.println("Found: " + (user3 != null ? user3.getName() : "null"));

        System.out.println("\nUpdating non-existent user:");
        userService.updateUserName("3", "Charlie");
    }
}
