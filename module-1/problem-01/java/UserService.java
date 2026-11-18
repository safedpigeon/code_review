package module1.problem01;

public class UserService {
    private final UserValidator validator;
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final AuditLogger auditLogger;

    public UserService(UserValidator validator, UserRepository userRepository, EmailService emailService, AuditLogger auditLogger) {
        this.validator = validator;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.auditLogger = auditLogger;
    }

    public void registerUser(String username, String email, String password) {
        System.out.println("Starting user registration for: " + username);

        // 1. Validation
        validator.validate(username, email, password);

        // 2. Persistence
        userRepository.saveUser(username, email, password);

        // 3. Notification
        emailService.sendWelcomeEmail(email, username);

        // 4. Audit Logging
        auditLogger.logUserRegistration(username);

        System.out.println("User registration completed successfully.");
    }
}
