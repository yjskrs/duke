public class Event extends Task {
    private String time;

    protected Event(String name, String time) {
        super(name);
        this.time = time;
    }

    public static Event createEvent(String name, String time) {
        return new Event(name, time);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + time + ")";
    }
}
