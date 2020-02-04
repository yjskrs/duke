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
        String[] inputData = input.split(" ");
        String command = inputData[0];
        String restOfInput = input.substring(command.length()).strip();
        switch (command) {
        case "list":
            return "Here are your tasks:\n"
                + TaskList.listTasks();
        case "done":
            return "Good job for completing the task:\n" 
                + TaskList.markTaskAsCompleted(Integer.valueOf(restOfInput));
        case "undo":
            return "o.o well... good luck completing the task:\n" 
                + TaskList.markTaskAsIncomplete(Integer.valueOf(restOfInput));
        case "delete":
            return "Removed task:\n" 
                + TaskList.removeTask(Integer.valueOf(restOfInput));
        case "todo":
            Todo newTodo = Todo.create(restOfInput);
            TaskList.addTask(newTodo);
            return "Added:\n" + newTodo;
        case "deadline":
            String[] details = restOfInput.split("/by");
            Deadline newDeadline = Deadline.create(details[0].strip(), details[1].strip());
            TaskList.addTask(newDeadline);
            return "Added:\n" + newDeadline;
        case "event":
            String[] details1 = restOfInput.split("/at");
            Event newEvent = Event.create(details1[0].strip(), details1[1].strip());
            TaskList.addTask(newEvent);
            return "Added:\n" + newEvent;
        case "find":
            Task[] tasksFound = TaskList.findTask(restOfInput);
            if (tasksFound == null) {
                return "No matching tasks found.";
            }
            String outputString = "";
            for (Task task : tasksFound) {
                outputString += (task + "\n");
            }
            return "Found matching task(s):\n" + outputString;
        default:
            return "????????????? gomenasai wakarimasen :(((";
        }
    }    
}
