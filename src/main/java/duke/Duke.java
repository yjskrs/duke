package duke;

import java.io.IOException;
import java.util.Scanner;

public class Duke {
    
    public static Scanner sc;
    
    public Duke() {
        this.sc = new Scanner(System.in);
        boolean success = Controller.initialize();
        while (!success) {
            success = Controller.initialize(sc.next());
        }
    }
    
    public void run() {
        while (sc.hasNext()) {
            boolean success = Controller.process(sc.nextLine());
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
}
