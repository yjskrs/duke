package duke;

/**
 * The <code>Task</code> class is an abstract class with a name and a boolean to represent whether
 * it is completed.
 *
 * @author Zhu Yijie
 */
public abstract class Task {
    protected String name;
    protected boolean isCompleted;
    
    /**
     * Creates a new Task object.
     *
     * @param name The name of the task.
     * @param isCompleted Whether the task is completed.
     */
    protected Task(String name, boolean isCompleted) {
        assert !name.isEmpty() : "Empty task name.";
        this.name = name;
        this.isCompleted = isCompleted;
    }
    
    /**
     * Marks the task as completed.
     */
    public void markAsCompleted() {
        isCompleted = true;
    }
    
    /**
     * Marks the task as incomplete.
     */
    public void markAsIncomplete() {
        isCompleted = false;
    }
    
    /**
     * Returns icon for whether the task is completed or not.
     *
     * @return The string representing the whether the task is completed or not.
     */
    public String getStatusIcon() {
        return (isCompleted ? "/" : "X"); // return tick or X symbols
    }
    
    /**
     * Returns a string formatting the task for saving in a file.
     *
     * @return The string representing the task.
     */
    public String format() {
        return (isCompleted ? "1 | " : "0 | ") + name;
    }
    
    public boolean matchesPartOfName(String str) {
        return name.contains(str);
    }
    
    public boolean matchesName(String str) {
        return str.equals(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Task) {
            Task task = (Task) obj;
            return task.name.equals(this.name);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}