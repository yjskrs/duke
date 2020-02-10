package duke;

import java.io.IOException;
import java.util.Scanner;

/**
 * The <code>Duke</code> class is the entry point of the program.
 *
 * @author Zhu Yijie
 */
public class Duke {
    /**
     * Creates and initialises a Duke object.
     */
    public Duke() {
        try {
            Storage.load();
        } catch (IOException e) {
            System.out.println("exception");
        }
        Ui.sayHello();
    }
    
    /**
     * Runs Duke.
     */
    public static void run() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                try {
                    Storage.save();
                } catch (IOException e) {
                    System.out.println("exception");
                }
                Ui.sayGoodbye();
                return;
            }
            String response = InputHandler.processInput(input);
            Ui.respond(response);
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
        return InputHandler.processInput(input);
    }
}
