package junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TaskProcessorTest {
    private final TaskProcessor taskProcessor = new TaskProcessor();

    @Test
    @Timeout(value = 4, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() {
        taskProcessor.longRunningTask();
    }
}
