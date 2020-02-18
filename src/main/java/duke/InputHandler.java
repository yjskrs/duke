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
        String command = input.split(" ")[0].toLowerCase();
        String arguments = input.substring(command.length()).strip();
        switch (command) {
        case "bye":
            return processBye();
        case "help":
            return processHelp();
        case "save":
            return processSave(taskList);
        case "list":
            return processList(taskList);
        case "todo":
            return processAddTodo(arguments, taskList);
        case "deadline":
            return processAddDeadline(arguments, taskList);
        case "event":
            return processAddEvent(arguments, taskList);
        case "done":
            return processDone(arguments, taskList);
        case "undo":
            return processUndo(arguments, taskList);
        case "delete":
            return processDelete(arguments, taskList);
        case "find":
            return processFind(arguments, taskList);
        default:
            return processUnrecognizedCommand();
        }
    }
    
    public static String processBye() {
        return "Awwww... Sad to see you go :( Hope to see you again soon!";
    }
    
    public static String processHelp() {
        return StringParser.combineTextWithNewline("Looking for help? Help is here!",
                "Here are the commands you can enter:",
                "list                         | list tasks",
                "find [(partial) task name]   | find existing task",
                "todo [name]                  | add todo with name",
                "deadline [name] /by [date]   | add deadline with name and due on date (in YYYY-MM-DD)",
                "event [event] /at [datetime] | add event with name and occurring at datetime",
                "delete [id]                  | delete task with id",
                "done [id]                    | mark task with id as done",
                "undo [id]                    | mark task with id as not done",
                "save                         | save tasks to storage",
                "bye                          | exit program");
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
    
    private static String processList(TaskList taskList) {
        String list = taskList.list();
        return "Here are your tasks:\n"
                + (list.isEmpty() ? "There are no tasks!" : list);
    }
    
    public static String processAddTodo(String taskContent, TaskList taskList) {
        if (taskContent.isEmpty()) {
            return "Todo name not specified! Please enter in the format: todo [name]";
        }
        Todo newTodo = new Todo(taskContent);
        try {
            taskList.add(newTodo);
            return "Added:\n" + newTodo;
        } catch (IllegalArgumentException e) {
            return "Duplicate task not added:\n" + newTodo;
        }
    }
    
    public static String processAddDeadline(String taskContent, TaskList taskList) {
        String taskName = taskContent.split("/by")[0].strip();
        String deadline = taskContent.substring(taskName.length()).replace("/by", "").strip();
        if (taskContent.isEmpty() || taskName.isEmpty() || deadline.isEmpty()) {
            return "Deadline name and/or time not specified! Please enter in the format: deadline [name] /by [time]";
        }
    
        Deadline newDeadline = new Deadline(taskName, deadline);
        try {
            taskList.add(newDeadline);
            return "Added:\n" + newDeadline;
        } catch (IllegalArgumentException e) {
            return "Duplicate task not added:\n" + newDeadline;
        }
    }
    
    public static String processAddEvent(String taskContent, TaskList taskList) {
        String taskName = taskContent.split("/at")[0].strip();
        String time = taskContent.substring(taskName.length()).replace("/at", "").strip();
        if (taskContent.isEmpty() || taskName.isEmpty() || time.isEmpty()) {
            return "Event name and/or time not specified! Please enter in the format: event [name] /at [time]";
        }
        
        Event newEvent = new Event(taskName, time);
        try {
            taskList.add(newEvent);
            return "Added:\n" + newEvent;
        } catch (IllegalArgumentException e) {
            return "Duplicate task not added:\n" + newEvent;
        }
    }
    
    public static String processDone(String id, TaskList taskList) {
        try {
            int idValue = Integer.parseInt(id);
            return "Good job for completing the task:\n"
                    + taskList.markAsCompleted(idValue);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return "Invalid task id. Please enter a valid id number!";
        }
    }
    
    public static String processUndo(String id, TaskList taskList) {
        try {
            int idValue = Integer.parseInt(id);
            return "o.o well... good luck completing the task:\n"
                    + taskList.markAsIncomplete(idValue);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return "Invalid task id. Please enter a valid id number!";
        }
    }
    
    public static String processDelete(String id, TaskList taskList) {
        try {
            int idValue = Integer.parseInt(id);
            return "Removed task:\n"
                    + taskList.remove(idValue);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return "Invalid task id. Please enter a valid id number!";
        }
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
    
    public static String processUnrecognizedCommand() {
        return "????????????? gomenasai wakarimasen :((( Enter `help` to get a list of commands.";
    }
}
