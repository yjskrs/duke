package duke;

public class Todo extends Task {
    private static final String IDENTIFIER = "TODO    ";
    
    public Todo(String name) {
        super(name);
    }
    
    public Todo(String name, boolean isCompleted) {
        super(name, isCompleted);
    }
    
    @Override
    public String toString() {
        return getStatusIcon() + "  "
                + IDENTIFIER + "  "
                + super.toString();
    }
}
