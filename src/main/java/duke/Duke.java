package duke;

import java.io.IOException;
import java.util.Scanner;

/**
 * The <code>Duke</code> class is the entry point of the program.
 *
 * @author Zhu Yijie
 */
public class Duke {
    
    private Scanner scanner;
    private TaskList tasklist;
    private Storage storage;
    
    /**
     * Creates and initialises a Duke object.
     */
    public Duke() {
        this.scanner = new Scanner(System.in);
        Ui.sayHello();
        String files = Storage.listExistingFiles();
        if (!files.isEmpty()) {
            Ui.askLoadStorage(files);
            while (true) {
                String input = scanner.nextLine().strip();
                if (input.equals("n")) {
                    this.storage = new Storage();
                    break;
                } else if (files.contains(input)) {
                    this.storage = new Storage(input);
                    break;
                } else {
                    Ui.askValidInput();
                }
            }
            
            try {
                this.tasklist = new TaskList(this.storage.load());
            } catch (IOException e) {
                this.tasklist = new TaskList();
            } finally {
                Ui.reportInitializeSuccess();
            }
        } else {
            this.storage = new Storage();
            this.tasklist = new TaskList();
        }
    }
    
    /**
     * Runs Duke.
     */
    public void run() {
        while (scanner.hasNext()) {
            String input = scanner.nextLine().strip();
            String response = InputHandler.processInput(input, tasklist, storage);
            Ui.respond(response);
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
        return InputHandler.processInput(input, tasklist, storage);
    }
    
    public static boolean initializeStorage(String input) {
        
        // if no, start fresh new copy
        Ui.reportInitializeSuccess();
        return true;
    }
}
