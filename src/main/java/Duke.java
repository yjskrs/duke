import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        Scanner scanner = new Scanner(System.in);
        String byeMsg = "Byebye *waves* See you again! *smiles*";
        String welcomeMsg = "Hello from\n" + logo;
        welcomeMsg += Parser.parse("Hello, I'm Duke! What's your name?");
        System.out.println(welcomeMsg);
        String name = scanner.nextLine().strip();
        welcomeMsg = Parser.parse("Hello " + name + "! What can I do for you?");
        System.out.println(welcomeMsg);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.toLowerCase().equals("bye")) {
                System.out.println(Parser.parse(byeMsg));
                return;
            }
            System.out.println(Parser.parse(input));
        }
    }
}
