package junit;

import static org.junit.jupiter.api.Assertions.*;

import junit.DatabaseConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {
    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(dbConnection.isConnected(), "Connection should be established.");
    }

    @Test
    void testConnectionIsClosed() {
        dbConnection.disconnect();  // Explicitly disconnecting to test
        assertFalse(dbConnection.isConnected(), "Connection should be closed.");
    }
}
