package duke;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;
import duke.utils.StringParser;

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
     * @return The response to the user input.
     */
    public static String processInput(String input, TaskList taskList, Storage storage) {
        String command = input.split(StringParser.SPACE)[0].toLowerCase();
        String arguments = input.substring(command.length()).strip();
        switch (command) {
        case "hello":
            return processHello();
        case "poke":
            return processPoke();
        case "bye":
            return processBye();
        case "help":
            return processHelp();
        case "save":
            return processSave(taskList, storage);
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
    
    private static String processHello() {
        return "Hello!! <3 <3";
    }
    
    private static String processPoke() {
        String[] responses = {"(- o - ) . z Z)",
                              "( > A < )/",
                              "/(T___T)\\",
                              "(0` - `!)/",
                              "(> - w -) >",
                              "(/ _ < .)",
                              "(/ > D <)/",
                              "(/q n q)/",
                              "/(o_ o)"};
        int rnd = (int) Math.floor(Math.random() * responses.length);
        return responses[rnd];
    }
    
    private static String processBye() {
        return "('A')/'' Bye! Come again soon.";
    }
    
    private static String processHelp() {
        return StringParser.combineTextWithNewline("Looking for help? Help is here! (^ u ^)/",
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
                "hello                        | greet me",
                "poke                         | poke me",
                "bye                          | say goodbye to me");
    }
    
    /**
     * Processes the save command.
     *
     * @param taskList Task list.
     * @return Save message.
     */
    private static String processSave(TaskList taskList, Storage storage) {
        try {
            storage.save(taskList.formatForStorage());
            return "Tasks saved! You may now exit the program.";
        } catch (IOException e) {
            return "Sorry! I couldn't save your tasks to disk :(";
        }
    }
    
    /**
     * Processes the list command.
     *
     * @param taskList Task list.
     * @return List message with listed tasks.
     */
    private static String processList(TaskList taskList) {
        String list = taskList.list();
        return "Here are your tasks:\n"
                + (list.isEmpty() ? "There are no tasks!" : list);
    }
    
    /**
     * Processes the todo command.
     *
     * @param taskContent Todo command contents.
     * @param taskList Task list.
     * @return Add todo message.
     */
    private static String processAddTodo(String taskContent, TaskList taskList) {
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
    
    /**
     * Processes the deadline command.
     *
     * @param taskContent Deadline command contents.
     * @param taskList Task list.
     * @return Add deadline message.
     */
    private static String processAddDeadline(String taskContent, TaskList taskList) {
        String taskName = taskContent.split(Deadline.TIME_DEMARCATOR)[0].strip();
        String deadline = taskContent.substring(taskName.length()).replace(Deadline.TIME_DEMARCATOR, "").strip();
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
    
    /**
     * Processes the event command.
     *
     * @param taskContent Event command contents.
     * @param taskList Task list.
     * @return Add event message.
     */
    private static String processAddEvent(String taskContent, TaskList taskList) {
        String taskName = taskContent.split(Event.TIME_DEMARCATOR)[0].strip();
        String time = taskContent.substring(taskName.length()).replace(Event.TIME_DEMARCATOR, "").strip();
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
    
    /**
     * Processes the done command.
     *
     * @param id Task id.
     * @param taskList Task list.
     * @return Mark task as done message.
     */
    private static String processDone(String id, TaskList taskList) {
        try {
            int idValue = Integer.parseInt(id);
            return "Good job for completing the task:\n"
                    + taskList.markAsCompleted(idValue);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return "Invalid task id. Please enter a valid id number!";
        }
    }
   
    /**
     * Processes the undo command.
     *
     * @param id Task id.
     * @param taskList Task list.
     * @return Mark task as not done message.
     */
    private static String processUndo(String id, TaskList taskList) {
        try {
            int idValue = Integer.parseInt(id);
            return "o.o well... good luck completing the task:\n"
                    + taskList.markAsIncomplete(idValue);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return "Invalid task id. Please enter a valid id number!";
        }
    }
    
    /**
     * Processes the delete command.
     *
     * @param id Task id.
     * @param taskList Task list.
     * @return Remove task message.
     */
    private static String processDelete(String id, TaskList taskList) {
        try {
            int idValue = Integer.parseInt(id);
            return "Removed task:\n"
                    + taskList.remove(idValue);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return "Invalid task id. Please enter a valid id number!";
        }
    }
    
    /**
     * Processes the find command.
     *
     * @param key Keyword to look for.
     * @param taskList Task list.
     * @return Lists tasks found.
     */
    private static String processFind(String key, TaskList taskList) {
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
    
    private static String processUnrecognizedCommand() {
        return "???????? gomenasai wakarimasen :((( Enter `help` to get a list of commands.";
    }
}
