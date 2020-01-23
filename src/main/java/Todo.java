public class Todo extends Task {
    protected Todo(String name) {
        super(name);
    }

    public static Todo createTodo(String name) {
        return new Todo(name);
    }
}
