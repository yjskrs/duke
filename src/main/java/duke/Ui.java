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
    private static final String NEWLINE = "\n";
    
    public static String getHelloMessage() {
        String welcomeMsg = LOGO + "Hello, I'm Duke!";
        return welcomeMsg;
    }

    /**
     * Prints a welcome message to standard output.
     *
     * <p>Used when starting up program.
     */
    public static void sayHello() {
//        String welcomeMsg = "Hello from\n" + LOGO;
        String welcomeMsg = parseOutput(getHelloMessage());
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
    
    public static void askLoadStorage(String options) {
        System.out.println(parseOutput("There seems to be existing task list(s). Would you like to load from file?\n"
                + "Enter the name of the file you would like to load from:\n" + options
                + "\nOtherwise, please enter `n`."));
    }
    
    public static void askValidInput() {
        System.out.println(parseOutput("I did not recognise that input. Please enter a valid input."));
    }
    
    public static void reportInitializeSuccess() {
        System.out.println(parseOutput("Your task list has been initialized successfully."));
    }
    
    public static void printError(Exception e) {
        System.out.println(e);
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
        if (output.isEmpty()) {
            return "";
        }
        
        String formattedOutput = LINE_SEPARATOR + NEWLINE + output + NEWLINE + LINE_SEPARATOR;
        String[] outputArr = formattedOutput.split(NEWLINE);
        String indentedOutput = "";
        for (String line : outputArr) {
            if (!line.isEmpty()) {
                indentedOutput += (INDENTATION + line.strip() + NEWLINE);
            }
        }
        return indentedOutput;
    }
}