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
        case "save":
            return processSave(taskList);
        case "bye":
            return processBye();
        case "list":
            return processList(taskList);
        case "done":
            return processDone(restOfInput, taskList);
        case "undo":
            return processUndo(restOfInput, taskList);
        case "delete":
            return processDelete(restOfInput, taskList);
        case "todo":
            return processAddTodo(restOfInput, taskList);
        case "deadline":
            return processAddDeadline(restOfInput, taskList);
        case "event":
            return processAddEvent(restOfInput, taskList);
        case "find":
            return processFind(restOfInput, taskList);
        case "help":
            return processHelp();
        default:
            return processUnrecognizedCommand();
        }
    }
    
    private static String processList(TaskList taskList) {
        return "Here are your tasks:\n"
                + taskList.list();
    }
    
    public static String processAddTodo(String taskContent, TaskList taskList) {
        Todo newTodo = new Todo(taskContent);
        boolean addTodoSuccess = taskList.add(newTodo);
        if (!addTodoSuccess) {
            return "Duplicate task not added:\n" + newTodo;
        }
        return "Added:\n" + newTodo;
    }
    
    public static String processAddDeadline(String taskContent, TaskList taskList) {
        String taskName = taskContent.split("/by")[0];
        String deadline = taskContent.substring(taskName.length() + 3);
    
        Deadline newDeadline = new Deadline(taskName.strip(), deadline.strip());
        boolean addDeadlineSuccess = taskList.add(newDeadline);
        if (!addDeadlineSuccess) {
            return "Duplicate task:\n" + newDeadline;
        }
        return "Added:\n" + newDeadline;
    }
    
    public static String processAddEvent(String taskContent, TaskList taskList) {
        String taskName = taskContent.split("/at")[0];
        String time = taskContent.substring(taskName.length() + 3);
        
        Event newEvent = new Event(taskName.strip(), time.strip());
        boolean addEventSuccess = taskList.add(newEvent);
        if (!addEventSuccess) {
            return "Duplicate task:\n" + newEvent;
        }
        return "Added:\n" + newEvent;
    }
    
    public static String processFind(String key, TaskList taskList) {
        Task[] tasksFound = taskList.find(key);
        if (tasksFound == null) {
            return "No matching tasks found.";
        }
        
        String outputString = "";
        for (Task task : tasksFound) {
            outputString += (task + "\n");
        }
        return "Found matching task(s):\n" + outputString;
    }
    
    public static String processDelete(String id, TaskList taskList) {
        return "Removed task:\n"
                + taskList.remove(Integer.valueOf(id));
    }
    
    public static String processDone(String id, TaskList taskList) {
        return "Good job for completing the task:\n"
                + taskList.markAsCompleted(Integer.valueOf(id));
    }
    
    public static String processUndo(String id, TaskList taskList) {
        return "o.o well... good luck completing the task:\n"
                + taskList.markAsIncomplete(Integer.valueOf(id));
    }
    
    public static String processHelp() {
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
    }
    
    public static String processSave(TaskList taskList) {
        try {
            Storage.save(taskList);
        } catch (IOException e) {
            System.out.println("exception");
        } finally {
            return "Tasks saved! You may now exit the program.";
        }
    }
    
    public static String processBye() {
        return "Awwww... Sad to see you go :( Hope to see you again soon!";
    }
    
    public static String processUnrecognizedCommand() {
        return "????????????? gomenasai wakarimasen :((( Enter `help` to get a list of commands.";
    }
}
