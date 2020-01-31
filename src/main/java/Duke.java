import java.io.IOException;
import java.util.Scanner;

public class Duke {

    public Duke() {
        try {
            TaskList.setup(Storage.load());
        } catch (IOException e) {

        }
        Ui.welcome();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.toLowerCase().equals("bye")) {
                try {
                    Storage.save(TaskList.format());
                    Ui.goodbye();
                } catch (IOException e) {

                }
                return;
            } else {
                Command command = Parser.handleInput(input);
                switch (command.type) {
                case LIST:
                    Ui.respond(TaskList.list());
                    break;
                case ADD_TODO:
                case ADD_DEADLINE:
                case ADD_EVENT:
                    Ui.respond(TaskList.addTask(command.task));
                    break;
                case DELETE:
                    Ui.respond(TaskList.removeTask(command.index));
                    break;
                case DONE:
                    Ui.respond(TaskList.doTask(command.index));
                    break;
                case UNDO:
                    Ui.respond(TaskList.undoTask(command.index));
                    break;
                default:
                    Ui.respond("Sorry! I don't understand that command :( Please try something else!");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}