package duke;

public abstract class Task {
    protected String name;
    protected boolean isCompleted;
    
    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }
    
    public Task(String name, boolean isCompleted) {
        this.name = name;
        this.isCompleted = isCompleted;
    }
    
    public void markAsCompleted() {
        isCompleted = true;
    }
    
    public void markAsIncomplete() {
        isCompleted = false;
    }
    
    public boolean matchPartial(String str) {
        return name.toLowerCase().contains(str.toLowerCase());
    }
    
    public boolean equals(String str) {
        return str.equalsIgnoreCase(name);
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
    
    /**
     * Returns a string formatting the task for saving in a file.
     *
     * @return The string representing the task.
     */
    public String format() {
        return (isCompleted ? "1 | " : "0 | ") + name;
    }
    
    public String getStatusIcon() {
        String statusIcon = isCompleted ? " \\u2713" : " ";
        return "[" + statusIcon + "]";
    }
    
    @Override
    public String toString() {
        return "\\033[1m" + name + "\\033[0m";
    }
}
