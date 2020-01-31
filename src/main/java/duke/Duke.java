package duke;

import java.io.IOException;
import java.util.Scanner;

public class Duke {

    public Duke() {
        try {
            Storage.load();
        } catch (IOException e) {

        }
        Ui.welcome();
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                try {
                    Storage.save();
                } catch (IOException e) {

                }
                Ui.goodbye();
                return;
            }
            String response = InputHandler.processInput(input);
            Ui.respond(response);
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}

// Input handler will handle inputs and call the respective functions that need to be called.
// Then subsequently input handler will return the output needed to be printed by Ui.
// Storage will directly send the data to tasklist
// Duke shouldn't deal with Task at all!!!
