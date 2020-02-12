package duke;

public class Event extends Task {
    private static final String IDENTIFIER = "EVENT   ";
    
    protected String at;
    
    public Event(String name, String at) {
        super(name);
        this.at = at;
    }
    
    public Event(String name, boolean isCompleted, String at) {
        super(name, isCompleted);
        this.at = at;
    }
    
    @Override
    public String format() {
        return "E | " + super.format() + " | " + at;
    }
    
    public String getTimeString() {
        return "(at: " + at + ")";
    }
    
    @Override
    public String toString() {
        return getStatusIcon() + "  "
                + IDENTIFIER + "  "
                + super.toString() + " "
                + getTimeString();
    }
}
