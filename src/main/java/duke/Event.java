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
    
    // return a string formatted for saving in file
    @Override
    public String format() {
        return "E | " + super.format() + " | " + at;
    }

    @Override
    public String toString() {
        return "[E][" + getStatusIcon() + "] " + super.toString() + " (at: " + at + ")";
    }
}