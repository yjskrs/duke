public class Parser {

    public static Command handleInput(String input) {
        String[] data = input.split(" ");
        switch (data[0]) {
            case "list":
                return new Command(CommandType.LIST);
            case "done":
                return new Command(CommandType.DONE, Integer.valueOf(data[1]));
            case "undo":
                return new Command(CommandType.UNDO, Integer.valueOf(data[1]));
            case "delete":
                return new Command(CommandType.DELETE, Integer.valueOf(data[1]));
            case "todo":
                Todo todo = Todo.createTodo(input.substring(4).strip(), false);
                return new Command(CommandType.ADD_TODO, todo);
            case "deadline":
                String[] details = input.substring(8).strip().split("/by");
                Deadline deadline = Deadline.createDeadline(details[0], details[1]);
                return new Command(CommandType.ADD_DEADLINE, deadline);
            case "event":
                String[] details1 = input.substring(5).strip().split("/at");
                Event event = Event.createEvent(details1[0], details1[1]);
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
