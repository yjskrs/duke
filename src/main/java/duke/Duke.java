package duke;

import duke.tasks.Task;
import duke.utils.DataParser;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * The <code>Duke</code> class is the entry point of the program.
 *
 * @author Zhu Yijie
 */
public class Duke {
    private static final String FILE_PATH = "./data/duke.txt";
    
    private TaskList taskList;
    private Storage storage;
    
    /**
     * Creates and initialises a Duke object.
     */
    public Duke() {
        Ui.sayHello();
        this.storage = new Storage(FILE_PATH);
        try {
            List<Task> tasks = DataParser.parseToTasks(this.storage.load());
            this.taskList = new TaskList(tasks);
            Ui.print("Task list loaded from storage. Enter `list` to see your tasks.");
        } catch (IOException e) {
            Ui.print("Failed to get tasks from storage. Starting with an empty list.");
            this.taskList = new TaskList();
        } catch (NullPointerException e) {
            Ui.print("There were no saved tasks. Starting with an empty list.");
            this.taskList = new TaskList();
        }
    }
    
    /**
     * Runs Duke.
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String response = InputHandler.processInput(input, taskList, storage);
            Ui.print(response);
            if (input.equals("bye")) {
                return;
            }
        }
    }
    
    /**
     * The main method starts the Duke program.
     *
     * @param args Input arguments.
     */
    public static void main(String[] args) {
        new Duke().run();
    }
    
    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        return InputHandler.processInput(input, taskList, storage);
    }
}
