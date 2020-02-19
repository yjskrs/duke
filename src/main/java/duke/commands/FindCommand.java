package duke.commands;

import duke.commands.exceptions.CommandException;
import duke.model.Storage;
import duke.model.TaskList;
import duke.tasks.Task;

public class FindCommand extends Command {
    public static final String MESSAGE_SUCCESS = "Found matching task(s):\n";
    public static final String MESSAGE_FAILURE = "No matching tasks found.";
    
    private final String key;
    
    public FindCommand(String key) {
        this.key = key;
    }
    
    public String execute(TaskList taskList, Storage storage) {
        Task[] tasksFound = taskList.find(key);
        if (tasksFound == null) {
            return MESSAGE_FAILURE;
        }
    
        String outputString = "";
        for (Task task : tasksFound) {
            outputString += (task + "\n");
        }
        return MESSAGE_SUCCESS + outputString;
    }
}
