package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @org.testng.annotations.Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @org.testng.annotations.Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @org.testng.annotations.Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @org.testng.annotations.Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @org.testng.annotations.Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));
    }
}



