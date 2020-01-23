import java.util.Scanner;

public class Duke {
    private static String logo = " ____        _        \n"
                               + "|  _ \\ _   _| | _____ \n"
                               + "| | | | | | | |/ / _ \\\n"
                               + "| |_| | |_| |   <  __/\n"
                               + "|____/ \\__,_|_|\\_\\___|\n";

    private static void initialise(Scanner scanner) {
        String welcomeMsg = "Hello from\n" + logo;
        welcomeMsg += Parser.parse("Hello, I'm Duke! What's your name?");
        System.out.println(welcomeMsg);
        String name = scanner.nextLine().strip();
        welcomeMsg = Parser.parse("Hello " + name + "! What can I do for you?");
        System.out.println(welcomeMsg);
    }

    private static void echo(String input) {
        System.out.println(Parser.parse(input));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initialise(scanner);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.toLowerCase().equals("bye")) {
                System.out.println(Parser.parse("Byebye *waves* See you again! ^^"));
                return;
            } else {
                if (input.toLowerCase().equals("list")) {
                    TaskList.list();
                } else {
                    if (input.length() >= 4 && input.substring(0, 4).equals("done")) {
                        TaskList.doTask(Integer.valueOf(input.substring(4).strip()));
                    } else if (input.length() >= 4 && input.substring(0, 4).equals("undo")) {
                        TaskList.undoTask(Integer.valueOf(input.substring(4).strip()));
                    } else if (TaskList.addTask(input)) {
                        System.out.println(Parser.parse("added: " + input));
                    }
                }
            }
        }
    }
}
