import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaskTest {
    @Test
    public void testStringConversion() {
        assertEquals("[X] nom", Task.createTask("nom").toString());
    }
    
    @Test
    public void testFormatConversion() {
        assertEquals("0 | nom", Task.createTask("nom").format());
    }
}
