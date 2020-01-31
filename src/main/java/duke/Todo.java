package duke;

public class Todo extends Task {
    protected Todo(String name, boolean isCompleted) {
        super(name, isCompleted);
    }

    public static Todo create(String name) {
        return new Todo(name, false);
    }

    public static Todo create(String name, boolean isCompleted) {
        return new Todo(name, isCompleted);
    }

    @Override
    public String toString() {
        return "[T][" + getStatusIcon() + "]" + super.toString();
    }
}