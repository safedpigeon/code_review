package module1.problem01;

import java.io.*;
import java.util.Date;

public class AuditLogger {
    public void logUserRegistration(String username) {
        try {
            FileWriter writer = new FileWriter("user_audit.log", true);
            writer.write("User " + username + " registered at " + new Date() + "\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Failed to write to audit log: " + e.getMessage());
        }
    }
}
