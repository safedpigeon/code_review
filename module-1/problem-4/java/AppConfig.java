package module1.problem4;

import java.util.Optional;

public class AppConfig {
    private final String apiUrl;
    private final String apiKey;
    private final int timeout;

    public AppConfig() {
        // In a production system, these would be loaded from a secure configuration provider,
        // environment variables, or a centralized config server (e.g., Spring Cloud Config).
        this.apiUrl = Optional.ofNullable(System.getenv("PAYMENT_API_URL"))
                              .orElse("https://api.payments.com/v1");
        this.apiKey = Optional.ofNullable(System.getenv("PAYMENT_API_KEY"))
                              .orElse("default_secret_key");
        this.timeout = Integer.parseInt(Optional.ofNullable(System.getenv("PAYMENT_TIMEOUT"))
                                               .orElse("5000"));
    }

    public String getApiUrl() { return apiUrl; }
    public String getApiKey() { return apiKey; }
    public int getTimeout() { return timeout; }
}
