public class Task {
    private String name;
    private boolean isDone;

    protected Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    protected Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
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

    public void setDone() {
        isDone = true;
    }

    public void resetDone() {
        isDone = false;
    }

    // return a string formatted for saving in file
    protected String format() {
        String str =  isDone ? "1 | " : "0 | ";
        str += name;
        return str;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + name;
    }
}
