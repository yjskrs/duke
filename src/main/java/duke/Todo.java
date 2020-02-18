package duke;

/**
 * The <code>Todo</code> class extends from Task.
 *
 * <p>A <code>Todo</code> object has a <code>name</code> and a <code>isCompleted</code> property.
 *
 * @author Zhu Yijie
 */
public class Todo extends Task {
    private static final String IDENTIFIER = "T";
    
    /**
     * Creates a new Todo object.
     *
     * @param name The name of the todo.
     */
    public Todo(String name) {
        super(name);
    }
    
    /**
     * Creates a new Todo object.
     *
     * @param name The name of the todo.
     * @param isCompleted Whether the todo is completed.
     */
    public Todo(String name, boolean isCompleted) {
        super(name, isCompleted);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Todo) {
            Todo todo = (Todo) obj;
            return todo.equals(this.name);
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        int parentHash = super.hashCode() * 31;
        return parentHash + IDENTIFIER.hashCode();
    }

    // return a string formatted for saving in file
    @Override
    public String format() {
        return "T | " + super.format();
    }

    @Override
    public String toString() {
        return getStatusIcon()
                + " " + "[" + IDENTIFIER + "]" + " "
                + super.toString();
    }
}
