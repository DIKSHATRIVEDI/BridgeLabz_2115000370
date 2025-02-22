package junit;

import junit.framework.TestCase;

public class MathUtilsTest extends TestCase {

    private MathUtils mathUtils;

    @Override
    protected void setUp() {
        mathUtils = new MathUtils();
    }

    public void testDivideByZero() {
        try {
            mathUtils.divide(10, 0);
            fail("Expected ArithmeticException was not thrown");
        } catch (ArithmeticException e) {
            assertEquals("Division by zero is not allowed", e.getMessage());
        }
    }

    public void testValidDivision() {
        assertEquals(5, mathUtils.divide(10, 2));
    }
}