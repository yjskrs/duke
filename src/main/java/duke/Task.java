package duke;

public abstract class Task {
    protected String name;
    protected boolean isCompleted;

    protected Task(String name, boolean isCompleted) {
        this.name = name;
        this.isCompleted = isCompleted;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    public void markAsIncomplete() {
        isCompleted = false;
    }

    public String getStatusIcon() {
        return (isCompleted ? "/" : "X"); // return tick or X symbols
    }
    
    // return a string formatted for saving in file
    public String format() {
        return (isCompleted ? "1 | " : "0 | ") + name;
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