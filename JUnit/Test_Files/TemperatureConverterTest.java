package junit;

import junit.framework.TestCase;

public class TemperatureConverterTest extends TestCase {
    public void testCelsiusToFahrenheit() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0), 0.001);
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100), 0.001);
        assertEquals(98.6, TemperatureConverter.celsiusToFahrenheit(37), 0.001);
    }

    public void testFahrenheitToCelsius() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32), 0.001);
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212), 0.001);
        assertEquals(37.0, TemperatureConverter.fahrenheitToCelsius(98.6), 0.001);
    }
}
