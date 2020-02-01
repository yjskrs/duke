package duke;

/**
 * The <code>InputHandler</code> class is a utility class to handle user input and call the
 * respective classes to deal with the input. It then retrieves the output from the classes
 * and sends it out.
 *
 * @author Zhu Yijie
 */
public class InputHandler {
    
    /**
     * Takes in user input, handles it and passes it to the relevant classes for processing.
     * Then returns the output to be sent to the user.
     *
     * @param input User input.
     * @return The response towards the user input.
     */
    public static String processInput(String input) {
        String[] data = input.split(" ");
        String command = data[0];
        String rest = input.substring(command.length()).strip();
        switch (command) {
        case "list":
            return TaskList.listTasks();
        case "done":
            return "Good job for completing the task:\n" 
                + TaskList.markTaskAsCompleted(Integer.valueOf(rest));
        case "undo":
            return "o.o well... good luck completing the task:\n" 
                + TaskList.markTaskAsIncomplete(Integer.valueOf(rest));
        case "delete":
            return "Removed task:\n" 
                + TaskList.removeTask(Integer.valueOf(rest));
        case "todo":
            Todo newTodo = Todo.create(rest);
            TaskList.addTask(newTodo);
            return "Added:\n" + newTodo;
        case "deadline":
            String[] details = rest.split("/by");
            Deadline newDeadline = Deadline.create(details[0].strip(), details[1].strip());
            TaskList.addTask(newDeadline);
            return "Added:\n" + newDeadline;
        case "event":
            String[] details1 = rest.split("/at");
            Event newEvent = Event.create(details1[0].strip(), details1[1].strip());
            TaskList.addTask(newEvent);
            return "Added:\n" + newEvent;
        default:
            return "????????????? gomenasai wakarimasen :(((";
        }
    }    
}
