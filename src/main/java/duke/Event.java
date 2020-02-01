package duke;

/**
 * The <code>Event</code> class extends from Task.
 * <p>
 * An <code>Event</code> object has a <code>name</code>, a <code>isCompleted</code> property and
 * an <code>at</code> property which represents the time of the event.
 *
 * @author Zhu Yijie
 */
public class Event extends Task {
    protected String at;
    
    /**
     * Creates a new Event object.
     *
     * @param name The name of the event.
     * @param isCompleted Whether the event is completed.
     * @param at Time of event.
     */
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
    public String format() {
        return "E | " + super.format() + " | " + at;
    }

    @Override
    public String toString() {
        return "[E][" + getStatusIcon() + "] " + super.toString() + " (at: " + at + ")";
    }
}