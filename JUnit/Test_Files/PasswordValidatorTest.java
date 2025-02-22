package junit;

import junit.framework.TestCase;

public class PasswordValidatorTest extends TestCase {
    public void testValidPassword() {
        assertTrue(PasswordValidator.isValid("StrongP4ss"));
    }

    public void testPasswordTooShort() {
        assertFalse(PasswordValidator.isValid("Shrt1"));
    }

    public void testPasswordNoUppercase() {
        assertFalse(PasswordValidator.isValid("weakpass1"));
    }

    public void testPasswordNoDigit() {
        assertFalse(PasswordValidator.isValid("NoDigitsHere"));
    }

    public void testPasswordEmpty() {
        assertFalse(PasswordValidator.isValid(""));
    }
}
