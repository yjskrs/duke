package duke.commands;

import duke.commands.exceptions.CommandException;
import duke.model.Storage;
import duke.model.TaskList;

public class HelpCommand extends Command {
    private final static String MESSAGE = "Looking for help? Help is here! (^ u ^)/\n"
            + "Here are the commands you can enter:\n"
            + "list                         | list tasks\n"
            + "find [(partial) task name]   | find existing task\n"
            + "todo [name]                  | add todo with name\n"
            + "deadline [name] /by [date]   | add deadline with name and due on date (in YYYY-MM-DD)\n"
            + "event [event] /at [datetime] | add event with name and occurring at datetime\n"
            + "delete [id]                  | delete task with id\n"
            + "done [id]                    | mark task with id as done\n"
            + "undo [id]                    | mark task with id as not done\n"
            + "save                         | save tasks to storage\n"
            + "hello                        | greet me\n"
            + "poke                         | poke me\n"
            + "bye                          | say goodbye to me\n";
    
    @Override
    public String execute(TaskList taskList, Storage storage) throws CommandException {
        return MESSAGE;
    }
}
