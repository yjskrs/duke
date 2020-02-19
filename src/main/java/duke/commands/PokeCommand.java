package duke.commands;

import duke.commands.exceptions.CommandException;
import duke.model.Storage;
import duke.model.TaskList;

public class PokeCommand extends Command {
    private static final String[] RESPONSES = {"(- o - ) . z Z)", "( > A < )/", "/(T___T)\\", "(0` - `!)/",
            "(> - w -) >", "(/ _ < .)", "(/ > D <)/", "(/q n q)/", "/(o_ o)"};

    @Override
    public String execute(TaskList taskList, Storage storage) throws CommandException {
        int randomIndex = (int) Math.floor(Math.random() * RESPONSES.length);
        return RESPONSES[randomIndex];
    }
}
