package duke;

/**
 * The <code>Ui</code> class is a utility class which deals with printing to standard output to
 * provide an interface to interact with the user.
 *
 * @author Zhu Yijie
 */
public class Ui {
    private static final String LOGO = " ____        _        \n"
                                     + "|  _ \\ _   _| | _____ \n"
                                     + "| | | | | | | |/ / _ \\\n"
                                     + "| |_| | |_| |   <  __/\n"
                                     + "|____/ \\__,_|_|\\_\\___|\n";
    private static final String LINE_SEPARATOR = "____________________________________________________________";
    private static final String INDENTATION = "    ";

    /**
     * Prints a welcome message to standard output.
     *
     * <p>Used when starting up program.
     */
    public static void sayHello() {
        String welcomeMsg = "Hello from\n" + LOGO;
        welcomeMsg += parseOutput("Hello, I'm Duke!");
        System.out.println(welcomeMsg);
    }

    /**
     * Prints a goodbye message to standard output.
     *
     * <p>Used when closing program.
     */
    public static void sayGoodbye() {
        String goodbyeMsg = parseOutput("Awwww... Sad to see you go :( Hope to see you again soon!");
        System.out.println(goodbyeMsg);
    }

    /**
     * Prints to standard output.
     *
     * @param contents String to be output.
     */
    public static void respond(String contents) {
        System.out.println(parseOutput(contents));
    }

    /**
     * Handles program output and formats it for printing to standard output.
     *
     * @param output String to be output.
     * @return The string to be printed to standard output.
     */
    public static String parseOutput(String output) {
        if (output.length() == 0) {
            return "";
        }
        String formattedOutput = LINE_SEPARATOR + "\n" + output + "\n" + LINE_SEPARATOR;
        String[] outputArr = formattedOutput.split("\n");
        String indentedOutput = "";
        for (String line : outputArr) {
            if (line.length() > 0) {
                indentedOutput += (INDENTATION + line.strip() + "\n");
            }
        }
        return indentedOutput;
    }
}