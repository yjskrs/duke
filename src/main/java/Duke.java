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
                } catch (IOException e) {

                }
                return;
            } else {
                Command cmd = Parser.handleInput(input);
                switch (cmd.type) {
                    case LIST:
                        Ui.respond(TaskList.list());
                        break;
                    case ADD_TODO:
                    case ADD_DEADLINE:
                    case ADD_EVENT:
                        TaskList.addTask(cmd.task);
                        break;
                    case DELETE:
                        TaskList.removeTask(cmd.index);
                        break;
                    case DONE:
                        TaskList.doTask(cmd.index);
                        break;
                    case UNDO:
                        TaskList.undoTask(cmd.index);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}