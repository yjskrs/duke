package duke.commands;

import duke.commands.exceptions.CommandException;
import duke.model.Storage;
import duke.model.TaskList;
import duke.tasks.Deadline;

public class DeadlineCommand extends Command {
    public static final String MESSAGE_SUCCESS = "Added:\n";
    public static final String MESSAGE_EMPTY_CONTENT =
            "Deadline name and/or time not specified! Please enter in the format: deadline [name] /by [time]";
    public static final String MESSAGE_DUPLICATE_TODO =
            "Duplicate task not added:\n";
    
    private final String name;
    private final String deadline;
    
    public DeadlineCommand(String content) {
        this.name = content.split(Deadline.TIME_DEMARCATOR)[0].strip();
        this.deadline = content.substring(name.length()).replace(Deadline.TIME_DEMARCATOR, "").strip();
    }
    
    public String execute(TaskList taskList, Storage storage) throws CommandException {
        if (name.isEmpty() || deadline.isEmpty()) {
            throw new CommandException(MESSAGE_EMPTY_CONTENT);
        }
    
        Deadline newDeadline = new Deadline(name, deadline);
        
        try {
            taskList.add(newDeadline);
            return MESSAGE_SUCCESS + newDeadline;
        } catch (IllegalArgumentException e) {
            throw new CommandException(MESSAGE_DUPLICATE_TODO + newDeadline);
        }
    }
}
