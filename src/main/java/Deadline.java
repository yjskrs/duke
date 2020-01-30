public class Deadline extends Task {
    private String deadline;

    protected Deadline(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

    public static Deadline createDeadline(String name, String deadline) {
        return new Deadline(name, deadline);
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
        return "[D]" + super.toString() + "(by: " + deadline + ")";
    }
}
