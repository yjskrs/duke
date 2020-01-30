public class Todo extends Task {
    protected Todo(String name) {
        super(name);
    }

    public static Todo createTodo(String name) {
        return new Todo(name);
    }

    // return a string formatted for saving in file
    @Override
    public String format() {
        String str = "T | ";
        str += super.format();
        return str;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
