import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Deadline extends Task {
    private LocalDate deadline;

    protected Deadline(String name, String deadline) {
        super(name);
        this.deadline = LocalDate.parse(deadline);
    }

    protected Deadline(String name, boolean isDone, String deadline) {
        super(name, isDone);
        this.deadline = LocalDate.parse(deadline);
    }

    public static Deadline createDeadline(String name, String deadline) {
        return new Deadline(name, deadline);
    }
    public static Deadline createDeadline(String name, String deadline, boolean isDone) {
        return new Deadline(name, isDone, deadline);
    }

    // return a string formatted for saving in file
    @Override
    public String format() {
        String str = "D | ";
        str += super.format();
        str += " | ";
        str += deadline;
        return str;
    }

    @Override
    public String toString() {
        String month = String.valueOf(deadline.getMonth());
        return "[D]" + super.toString() +
                "(by: " + deadline.getDayOfMonth() + " " + month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase() + " " + deadline.getYear() + ")";
    }
}
