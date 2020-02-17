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
     */
    public Task(String name) {
        assert !name.isEmpty() : "Empty task name.";
        this.name = name;
        this.isCompleted = false;
    }
    
    /**
     * Creates a new Task object.
     *
     * @param name The name of the task.
     * @param isCompleted Whether the task is completed.
     */
    public Task(String name, boolean isCompleted) {
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
     * Checks if provided task name matches this task's name partially, ignoring case.
     *
     * @param taskname Task name to check.
     * @return True if taskname is contained in this task's name, false otherwise.
     */
    public boolean matchPartial(String taskname) {
        return name.toLowerCase().contains(taskname.toLowerCase());
    }
    
    /**
     * Checks if provided task name matches this task's name fully, ignoring case.
     *
     * @param taskname Task name to check.
     * @return True if taskname is equivalent to this task's name, false otherwise.
     */
    public boolean equals(String taskname) {
        return name.equalsIgnoreCase(taskname);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Task) {
            Task task = (Task) obj;
            return task.equals(this.name);
        } else {
            return false;
        }
    }
    
    /**
     * Returns a string formatting the task for saving in a file.
     *
     * @return The string representing the task.
     */
    public String format() {
        String completedString = isCompleted ? "1 | " : "0 | ";
        return completedString + name;
    }
    
    /**
     * Returns icon for whether the task is completed or not.
     *
     * @return The string representing the whether the task is completed or not.
     */
    public String getStatusIcon() {
        String statusIcon = isCompleted ? "/" : " ";
        return "[" + statusIcon + "]";
    }
    
    @Override
    public String toString() {
        return name;
    }
}