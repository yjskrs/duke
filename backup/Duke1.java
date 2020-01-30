import java.util.Scanner;

public class Duke {

    public Duke() {
        Storage.load();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                Storage.save();
                return;
            } else {
                Command cmd = Parser.handleInput(input);
                switch (cmd.type) {
                    case LIST: 

                    case ADD_TODO:

                    case ADD_DEADLINE:

                    case ADD_EVENT:

                    case DELETE:

                    case DO:

                    case UNDO:

                    default:
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new Duke("./data/duke.txt").run();
    }
