package junit;

import junit.framework.TestCase;

public class StringUtilsTest extends TestCase {

    private StringUtils utils;

    @Override
    protected void setUp() {
        utils = new StringUtils(); // Initialize before each test
    }

    public void testReverse() {
        assertEquals("dcba", utils.reverse("abcd"));
    }

    public void testIsPalindrome() {
        assertTrue(utils.isPalindrome("madam"));
        assertFalse(utils.isPalindrome("hello"));
    }

    public void testToUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"));
    }
}
