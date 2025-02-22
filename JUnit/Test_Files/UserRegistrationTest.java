package junit;

import junit.framework.TestCase;

public class UserRegistrationTest extends TestCase {
    private UserRegistration userRegistration;

    @Override
    protected void setUp() {
        userRegistration = new UserRegistration();
    }

    public void testValidUserRegistration() {
        try {
            userRegistration.registerUser("JohnDoe", "john.doe@example.com", "SecurePass123");
        } catch (IllegalArgumentException e) {
            fail("Registration should not fail for valid inputs");
        }
    }

    public void testEmptyUsername() {
        try {
            userRegistration.registerUser("", "valid.email@example.com", "ValidPass123");
            fail("Expected IllegalArgumentException for empty username");
        } catch (IllegalArgumentException e) {
            assertEquals("Username cannot be empty", e.getMessage());
        }
    }

    public void testInvalidEmail() {
        try {
            userRegistration.registerUser("JohnDoe", "invalid-email", "ValidPass123");
            fail("Expected IllegalArgumentException for invalid email");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid email format", e.getMessage());
        }
    }

    public void testShortPassword() {
        try {
            userRegistration.registerUser("JohnDoe", "john.doe@example.com", "12345");
            fail("Expected IllegalArgumentException for short password");
        } catch (IllegalArgumentException e) {
            assertEquals("Password must be at least 8 characters long", e.getMessage());
        }
    }

    public void testNullValues() {
        try {
            userRegistration.registerUser(null, "john.doe@example.com", "ValidPass123");
            fail("Expected IllegalArgumentException for null username");
        } catch (IllegalArgumentException e) {
            assertEquals("Username cannot be empty", e.getMessage());
        }

        try {
            userRegistration.registerUser("JohnDoe", null, "ValidPass123");
            fail("Expected IllegalArgumentException for null email");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid email format", e.getMessage());
        }

        try {
            userRegistration.registerUser("JohnDoe", "john.doe@example.com", null);
            fail("Expected IllegalArgumentException for null password");
        } catch (IllegalArgumentException e) {
            assertEquals("Password must be at least 8 characters long", e.getMessage());
        }
    }
}
