package junit;

import junit.framework.TestCase;
import java.text.ParseException;

public class DateFormatterTest extends TestCase {
    public void testValidDateFormat() throws ParseException {
        assertEquals("25-12-2023", DateFormatter.formatDate("2023-12-25"));
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"));
    }

    public void testInvalidDateFormat() {
        try {
            DateFormatter.formatDate("25-12-2023");
            fail("Expected ParseException for invalid format");
        } catch (ParseException e) {
            assertEquals("Invalid date format", e.getMessage());
        }
    }

    public void testEmptyDate() {
        try {
            DateFormatter.formatDate("");
            fail("Expected ParseException for empty string");
        } catch (ParseException e) {
            assertEquals("Invalid date format", e.getMessage());
        }
    }

    public void testNullDate() {
        try {
            DateFormatter.formatDate(null);
            fail("Expected ParseException for null input");
        } catch (ParseException e) {
            assertEquals("Invalid date format", e.getMessage());
        }
    }
}
