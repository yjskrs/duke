package duke;

public class InputHandler {

    public static String processInput(String input) {
        String[] inputData = input.split(" ");
        String command = inputData[0];
        String restOfInput = input.substring(command.length()).strip();
        switch (command) {
        case "list":
            return TaskList.listTasks();
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
