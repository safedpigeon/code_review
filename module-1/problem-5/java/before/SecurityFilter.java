package module1.problem5.before;

import java.util.ArrayList;
import java.util.List;

/**
 * SecurityFilter handles the filtering of blocked IP addresses.
 * In this naive implementation, we use an ArrayList to store blocked IPs.
 */
public class SecurityFilter {
    private List<String> blockedIps;

    public SecurityFilter() {
        this.blockedIps = new ArrayList<>();
    }

    public void addBlockedIp(String ip) {
        blockedIps.add(ip);
    }

    public boolean isBlocked(String ip) {
        // Linear search through the list to check if IP is blocked
        for (String blockedIp : blockedIps) {
            if (blockedIp.equals(ip)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SecurityFilter filter = new SecurityFilter();
        // Simulating a large blocklist
        for (int i = 0; i < 10000; i++) {
            filter.addBlockedIp("192.168.1." + i);
        }

        long startTime = System.nanoTime();
        boolean blocked = filter.isBlocked("192.168.1.9999");
        long endTime = System.nanoTime();

        System.out.println("Is blocked: " + blocked);
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
    }
}
