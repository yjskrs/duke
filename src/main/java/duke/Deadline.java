package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * The <code>Deadline</code> class extends from Task.
 *
 * <p>A <code>Deadline</code> object has a <code>name</code>, a <code>isCompleted</code> property
 * and a <code>by</code> property which represents the time of the event.
 *
 * @author Zhu Yijie
 */
public class Deadline extends Task {
    private static final String IDENTIFIER = "D";
    private LocalDate by;
    
    /**
     * Creates a new Deadline object.
     *
     * @param name The name of the deadline.
     * @param by Time the deadline is due.
     */
    public Deadline(String name, String by) {
        super(name);
        assert !by.isEmpty() : "Empty by string.";
        this.by = LocalDate.parse(by);
    }
    
    /**
     * Creates a new Deadline object.
     *
     * @param name The name of the deadline.
     * @param isCompleted Whether the deadline is completed.
     * @param by Time the deadline is due.
     */
    public Deadline(String name, boolean isCompleted, String by) {
        super(name, isCompleted);
        assert !by.isEmpty() : "Empty by string.";
        this.by = LocalDate.parse(by);
    }

    //    DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(by)
    //    DateTimeFormatter.ofPattern("d MMM uuuu")
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Deadline) {
            Deadline deadline = (Deadline) obj;
            return deadline.equals(this.name);
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
        return IDENTIFIER + " | " + super.format() + " | " + by;
    }
    
    public String getTimeString() {
        return "(by: " + DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(by) + ")";
    }

    @Override
    public String toString() {
        return getStatusIcon()
                + " " + "[" + IDENTIFIER + "]" + " "
                + super.toString() + " "
                + getTimeString();
    }
}
