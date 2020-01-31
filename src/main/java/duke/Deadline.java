package duke;

import java.time.LocalDate;

public class Deadline extends Task {
    protected LocalDate by;

    protected Deadline(String name, boolean isCompleted, LocalDate by) {
        super(name, isCompleted);
        this.by = by;
    }
    
    public static Deadline create(String name, String by) {
        return new Deadline(name, false, LocalDate.parse(by));
    }

    public static Deadline create(String name, boolean isCompleted, String by) {
        return new Deadline(name, isCompleted, LocalDate.parse(by));
    }

    @Override
    public String toString() {
        return "[D][" + getStatusIcon() + "]" + super.toString() + " (by:" + by + ")";
    }    
}

