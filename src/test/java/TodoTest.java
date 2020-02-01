import duke.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void testStringConversion() {
        assertEquals("[T][X] nom", Todo.create("nom").toString());
    }
    
    @Test
    public void testFormatConversion() {
        assertEquals("T | 0 | nom", Todo.create("nom").format());
    }
    
    @Test
    public void testMarkAsCompleted() {
        Todo newTodo = Todo.create("nom");
        newTodo.markAsCompleted();
        assertEquals("T | 1 | nom", newTodo.format());
    }
}
