package module1.problem5.after;

import java.util.HashSet;
import java.util.Set;

/**
 * SecurityFilter handles the filtering of blocked IP addresses.
 * In this optimized implementation, we use a HashSet to store blocked IPs,
 * providing O(1) average time complexity for lookups.
 */
public class SecurityFilter {
    private Set<String> blockedIps;

    public SecurityFilter() {
        this.blockedIps = new HashSet<>();
    }

    public void addBlockedIp(String ip) {
        blockedIps.add(ip);
    }

    public boolean isBlocked(String ip) {
        // HashSet provides O(1) average time complexity for contains check
        return blockedIps.contains(ip);
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
