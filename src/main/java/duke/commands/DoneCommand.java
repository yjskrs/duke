package duke.commands;

import duke.commands.exceptions.CommandException;
import duke.model.Storage;
import duke.model.TaskList;

public class DoneCommand extends Command {
    private static final String MESSAGE_SUCCESS = "Good job for completing the task:\n";
    private static final String MESSAGE_FAILURE = "Invalid task id. Please enter a valid id number!";
    
    private final String id;
    
    public DoneCommand(String id) {
        this.id = id;
    }
    
    @Override
    public String execute(TaskList taskList, Storage storage) throws CommandException {
        try {
            return MESSAGE_SUCCESS + taskList.markAsCompleted(Integer.parseInt(id));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new CommandException(MESSAGE_FAILURE);
        }
    }
}
