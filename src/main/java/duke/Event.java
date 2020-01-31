package duke;

public class Event extends Task {
    protected String at;

    protected Event(String name, boolean isCompleted, String at) {
        super(name, isCompleted);
        this.at = at;
    }

    public static Event create(String name, String at) {
        return new Event(name, false, at);
    }

    public static Event create(String name, boolean isCompleted, String at) {
        return new Event(name, isCompleted, at);
    }

    @Override
    public String toString() {
        return "[E][" + getStatusIcon() + "]" + super.toString() + " (at:" + at + ")";
    }
}