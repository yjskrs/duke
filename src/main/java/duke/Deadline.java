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
    
    // return a string formatted for saving in file
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

