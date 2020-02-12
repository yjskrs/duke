package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Deadline extends Task {
    private static final String IDENTIFIER = "DEADLINE";
    protected LocalDate by;
    
    public Deadline(String name, String by) {
        super(name);
        this.by = LocalDate.parse(by);
    }
    
    public Deadline(String name, boolean isCompleted, String by) {
        super(name, isCompleted);
        this.by = LocalDate.parse(by);
    }
    
//    DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(by)
//    DateTimeFormatter.ofPattern("d MMM uuuu")
    
    @Override
    public String format() {
        return "D | " + super.format() + " | " + by;
    }
    
    public String getTimeString() {
        return "(by: " + DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(by) + ")";
    }
    
    @Override
    public String toString() {
        return getStatusIcon() + "  "
                + IDENTIFIER + "  "
                + super.toString() + " "
                + getTimeString();
    }
}
