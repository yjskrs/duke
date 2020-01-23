public class Task {
    private String name;
    private boolean isDone;

    private Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public static Task createTask(String name) {
        return new Task(name);
    }

    public String getName() {
        return name;
    }

    public String getStatusIcon() {
        return (isDone ? "/" : "X"); //return tick or X symbols
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + name;
    }
}
