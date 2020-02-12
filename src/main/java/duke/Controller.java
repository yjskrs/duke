package duke;

import java.io.IOException;

/**
 * Handles the Ui (view), TaskList (model) and Storage, while receiving user input from Duke and
 * reporting back to Duke (with boolean values (?)).
 */
public class Controller {
    
    public static TaskList taskList;
    
    /**
     *
     * @return True if initialization complete, false if issues occurred.
     */
    public static boolean initialize() {
        Ui.sayHello();
        if (Storage.isEmpty()) {
            taskList = new TaskList();
            return true;
        } else {
            Ui.askLoadStorage();
            return false;
        }
    }
    
    /**
     *
     * @param input User input.
     * @return True if initialization complete, false if issues occurred.
     */
    public static boolean initialize(String input) {
        boolean yesLoad = input.equalsIgnoreCase("y");
        boolean noLoad = input.equalsIgnoreCase("n");
        if (!yesLoad && !noLoad) {
            Ui.askValidInput();
            return false;
        }
    
        // ask user if they want to load from storage
        // if yes, try load
        // if no, start fresh new copy
        if (yesLoad) {
            String data;
            try {
                data = Storage.load();
                taskList = new TaskList(DataParser.parseToTask(data));
            } catch (Exception e) {
                Ui.printError(e);
                taskList = new TaskList();
            }
        } else {
            taskList = new TaskList();
        }
        Ui.reportInitializeSuccess();
        return true;
    }
    
    public static boolean process(String input) {
    
    }
    
    public static boolean terminate() {
        try {
            Storage.save(taskList);
        } catch (IOException e) {
            System.out.println("exception");
        }
        Ui.sayGoodbye();
        return;
    }
}
