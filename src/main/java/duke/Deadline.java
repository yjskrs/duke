package duke;

import java.time.LocalDate;

/**
 * The <code>Deadline</code> class extends from Task.
 *
 * <p>A <code>Deadline</code> object has a <code>name</code>, a <code>isCompleted</code> property
 * and a <code>by</code> property which represents the time of the event.
 *
 * @author Zhu Yijie
 */
public class Deadline extends Task {
    protected LocalDate by;
    
    /**
     * Creates a new Deadline object.
     *
     * @param name The name of the deadline.
     * @param isCompleted Whether the deadline is completed.
     * @param by Time the deadline is due.
     */
    protected Deadline(String name, boolean isCompleted, LocalDate by) {
        super(name, isCompleted);
        this.by = by;
    }
    
    public static Deadline create(String name, String by) {
        assert !by.isEmpty() : "Empty by string.";
        return new Deadline(name, false, LocalDate.parse(by));
    }

    public static Deadline create(String name, boolean isCompleted, String by) {
        assert !by.isEmpty() : "Empty by string.";
        return new Deadline(name, isCompleted, LocalDate.parse(by));
    }
    
    @Override
    public String format() {
        return "D | " + super.format() + " | " + by;
    }

    @Override
    public String toString() {
        String month = String.valueOf(by.getMonth());
        String formattedDate = by.getDayOfMonth() + " "
                                + month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase() + " "
                                + by.getYear();
        return "[D][" + getStatusIcon() + "] " + super.toString() + " (by: " + formattedDate + ")";
    }    
}

