import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Duke {
    private static final String FILENAME = "./data/duke.txt";
    private static final File FILE = new File("./data/duke.txt");
    private static final String LOGO = " ____        _        \n"
                                     + "|  _ \\ _   _| | _____ \n"
                                     + "| | | | | | | |/ / _ \\\n"
                                     + "| |_| | |_| |   <  __/\n"
                                     + "|____/ \\__,_|_|\\_\\___|\n";

    // initialise the user and loads data from file to TaskList if file exists.
    private static void initialise(Scanner scanner) {
        String welcomeMsg = "Hello from\n" + LOGO;
        welcomeMsg += Parser.parse("Hello, I'm Duke! What's your name?");
        System.out.println(welcomeMsg);
        String name = scanner.nextLine().strip();
//        if (FILE.length() == 0) { // if file is empty or file does not exist
            welcomeMsg = Parser.parse("Hello " + name + "! What can I do for you?");
//        } else { // initialise TaskList
//            Scanner fileScanner = new Scanner(FILE);
//            while (fileScanner.hasNextLine()) {
//                String input = fileScanner.nextLine();
//                String[] inputArr = input.split(" | ");
//                switch (inputArr[0]) {
//                    case "T":
//                        TaskList.addTask();
//                        break;
//                    case "D":
//
//                        break;
//                    case "E":
//
//                        break;
//                    default:
//                        break;
//                }
//            }
//        }
        System.out.println(welcomeMsg);

    }

    private static void echo(String input) {
        System.out.println(Parser.parse(input));
    }

    public static void main(String[] args) throws IOException {
        //BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
        FileWriter writer = new FileWriter(FILE, false);
        Scanner scanner = new Scanner(System.in);
        initialise(scanner);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.toLowerCase().equals("bye")) {
                try {
                    writer.write(TaskList.format());
                } catch (IOException e) {

                }
                writer.close();
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
                    } else if (input.length() >= 6 && input.substring(0, 6).equals("delete")) {
                        TaskList.removeTask(Integer.valueOf(input.substring(6).strip()));
                    } else {
                        String[] inputArr = input.split(" ");
                        if (inputArr[0].equals("todo")) {
                            if (input.substring(4).strip().length() == 0) {
                                System.out.println(Parser.parse("todo what? @-@"));
                            } else {
                                TaskList.addTask("T", input.substring(4).strip());
                                System.out.println(Parser.parse("added:" + "\n    " + TaskList.getLastTaskAdded()));
                            }
                        } else {
                            if (inputArr[0].equals("deadline")) {
                                String[] forTime = input.split("/by");
                                if (forTime.length < 2 || forTime[0].substring(8).strip().length() == 0) {
                                    System.out.println(Parser.parse("what deadline? @-@"));
                                } else {
                                    TaskList.addTask("D", forTime[0].substring(8).strip(), forTime[1].strip());
                                    System.out.println(Parser.parse("added:" + "\n    " + TaskList.getLastTaskAdded()));
                                }
                            } else if (inputArr[0].equals("event")) {
                                String[] forTime = input.split("/at");
                                if (forTime.length < 2 || forTime[0].substring(5).strip().length() == 0) {
                                    System.out.println(Parser.parse("what event?? @-@"));
                                } else {
                                    TaskList.addTask("E", forTime[0].substring(5).strip(), forTime[1].strip());
                                    System.out.println(Parser.parse("added:" + "\n    " + TaskList.getLastTaskAdded()));
                                }
                            } else {
                                System.out.println(Parser.parse("Sorry! I don't understand that command :( Please try something else!"));
                            }
                        }
                    }
                }
            }
        }
    }
}
