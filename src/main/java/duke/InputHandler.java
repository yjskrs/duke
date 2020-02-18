package duke;

import java.io.IOException;

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
    public static String processInput(String input, TaskList taskList) {
        String[] inputData = input.split(" ");
        String command = inputData[0];
        String restOfInput = input.substring(command.length()).strip();
        switch (command) {
        case "bye":
            try {
                Storage.save(taskList);
            } catch (IOException e) {
                System.out.println("exception");
            } finally {
                return "Awwww... Sad to see you go :( Hope to see you again soon!";
            }
        case "list":
            return "Here are your tasks:\n"
                + taskList.list();
        case "done":
            return "Good job for completing the task:\n" 
                + taskList.markAsCompleted(Integer.valueOf(restOfInput));
        case "undo":
            return "o.o well... good luck completing the task:\n" 
                + taskList.markAsIncomplete(Integer.valueOf(restOfInput));
        case "delete":
            return "Removed task:\n" 
                + taskList.remove(Integer.valueOf(restOfInput));
        case "todo":
            Todo newTodo = new Todo(restOfInput);
            boolean addTodoSuccess = taskList.add(newTodo);
            if (!addTodoSuccess) {
                return "Duplicate task not added:\n" + newTodo;
            }
            return "Added:\n" + newTodo;
        case "deadline":
            String[] details = restOfInput.split("/by");
            Deadline newDeadline = new Deadline(details[0].strip(), details[1].strip());
            boolean addDeadlineSuccess = taskList.add(newDeadline);
            if (!addDeadlineSuccess) {
                return "Duplicate task:\n" + newDeadline;
            }
            return "Added:\n" + newDeadline;
        case "event":
            String[] details1 = restOfInput.split("/at");
            Event newEvent = new Event(details1[0].strip(), details1[1].strip());
            boolean addEventSuccess = taskList.add(newEvent);
            if (!addEventSuccess) {
                return "Duplicate task:\n" + newEvent;
            }
            return "Added:\n" + newEvent;
        case "find":
            Task[] tasksFound = taskList.find(restOfInput);
            if (tasksFound == null) {
                return "No matching tasks found.";
            }
            String outputString = "";
            for (Task task : tasksFound) {
                outputString += (task + "\n");
            }
            return "Found matching task(s):\n" + outputString;
        case "help":
            return "Looking for help? Help is here!\n"
                    + "Here are some commands you can enter:\n"
                    + "`list`: list tasks\n"
                    + "`find [(partial) task name]`: find tasks from existing tasks\n"
                    + "`todo [todo name]`: add todo with name [todo name]\n"
                    + "`deadline [deadline name] /by [date in YYYY-MM-DD format]`: \n"
                    + "add deadline with name [deadline name] and due on [date]\n"
                    + "`event [event name] /at [datetime]`: add event with name [event name] at time [datetime]\n"
                    + "`delete [task id]`: delete task with id [task id]\n"
                    + "`done [task id]`: mark task with id [task id] as done\n"
                    + "`undo [task id]`: mark task with id [task id] as not done\n"
                    + "`bye`: exit program\n";


        default:
            return "????????????? gomenasai wakarimasen :((( Enter `help` to get a list of commands.";
        }
    }
}
