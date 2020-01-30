public class Command {
    protected CommandType type;
    protected int index;
    protected Task task;

    public Command(CommandType type, Task task) {
        this.type = type;
        this.index = -1;
        this.task = task;
    }

    public Command(CommandType type, int index) {
        this.type = type;
        this.index = index;
        this.task = null;
    }

    public Command(CommandType type) {
        this.type = type;
        this.index = -1;
        this.task = null;
    }
}
