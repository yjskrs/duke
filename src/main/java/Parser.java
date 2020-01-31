public class Parser {

    public static Command handleInput(String input) {
        String[] data = input.split(" ");
        String cmd = data[0];
        String rest = input.substring(cmd.length()).strip();
        switch (cmd) {
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

    public static String parse(String input) {
        if (input.length() > 0) {
            String output = "    ____________________________________________________________\n";
            output += "    ";
            output += input;
            output += "\n";
            output += "    ____________________________________________________________";
            return output;
        }
        return "";
    }
}
