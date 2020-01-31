package duke;

/**
 * The <code>Parser</code> class is responsible for formatting user input into format readable
 * by the Duke program, which involves the <code>Command</code> class.
 *
 * @author Zhu Yijie
 */
public class Parser {
    
    /**
     * Handles the user input and formats it into a command for processing
     * in the Duke program.
     * <p>
     * If input is invalid, returns a command of type invalid.
     *
     * @param input The string input by the user.
     * @return The corresponding command.
     */
    public static Command handleInput(String input) {
        String[] data = input.split(" ");
        String command = data[0];
        String rest = input.substring(command.length()).strip();
        switch (command) {
            case "list":
                return new Command(CommandType.LIST);
            case "done":
                return new Command(CommandType.DONE, Integer.valueOf(rest));
            case "undo":
                return new Command(CommandType.UNDO, Integer.valueOf(rest));
            case "delete":
                return new Command(CommandType.DELETE, Integer.valueOf(rest));
            case "todo":
                Todo todo = Todo.createTodo(rest, false);
                return new Command(CommandType.ADD_TODO, todo);
            case "deadline":
                String[] details = rest.split("/by");
                Deadline deadline = Deadline.createDeadline(details[0].strip(), details[1].strip());
                return new Command(CommandType.ADD_DEADLINE, deadline);
            case "event":
                String[] details1 = rest.split("/at");
                Event event = Event.createEvent(details1[0].strip(), details1[1].strip());
                return new Command(CommandType.ADD_EVENT, event);
            default:
                return new Command(CommandType.HUH);
        }
    }
}
