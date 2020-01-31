public class Todo extends Task {
    protected Todo(String name) {
        super(name);
    }

    protected Todo(String name, boolean isDone) {
        super(name, isDone);
    }

    public static Todo createTodo(String name) {
        return new Todo(name);
    }

    public static Todo createTodo(String name, boolean isDone) {
        return new Todo(name, isDone);
    }

    // return a string formatted for saving in file
    @Override
    public String format() {
        return "T | " + super.format();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
