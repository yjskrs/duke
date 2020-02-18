package duke;

/**
 * The <code>Event</code> class extends from Task.
 *
 * <p>An <code>Event</code> object has a <code>name</code>, a <code>isCompleted</code> property
 * and an <code>at</code> property which represents the time of the event.
 *
 * @author Zhu Yijie
 */
public class Event extends Task {
    private static final String IDENTIFIER = "E";
    private String at;
    
    /**
     * Creates a new Event object.
     *
     * @param name The name of the event.
     * @param at Time of event.
     */
    public Event(String name, String at) {
        super(name);
        assert !at.isEmpty() : "Empty at string.";
        this.at = at;
    }
    
    /**
     * Creates a new Event object.
     *
     * @param name The name of the event.
     * @param isCompleted Whether the event is completed.
     * @param at Time of event.
     */
    public Event(String name, boolean isCompleted, String at) {
        super(name, isCompleted);
        assert !at.isEmpty() : "Empty at string.";
        this.at = at;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Event) {
            Event event = (Event) obj;
            return event.equals(this.name);
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        int parentHash = super.hashCode() * 31;
        return parentHash + IDENTIFIER.hashCode();
    }

    @Override
    public String format() {
        return IDENTIFIER + " | " + super.format() + " | " + at;
    }
    
    public String getTimeString() {
        return "(at: " + at + ")";
    }

    @Override
    public String toString() {
        return getStatusIcon()
                + " " + "[" + IDENTIFIER + "]" + " "
                + super.toString() + " "
                + getTimeString();
    }
}
