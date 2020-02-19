package duke.commands;

import duke.model.Storage;
import duke.model.TaskList;

public class ByeCommand extends Command {
    private final static String MESSAGE = "('A')/'' Bye! Come again soon.";
    
    public String execute(TaskList taskList, Storage storage) {
        return MESSAGE;
    }
}
