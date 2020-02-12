package duke;

public class Ui {
    private static final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    private static final String LINE_SEPARATOR = "____________________________________________________________";
    private static final String INDENTATION = "    ";
    private static final String NEW_LINE = "\n";
    
    public static String getHelloMessage() {
        String welcomeMsg = "Hello, I'm Duke!";
        return welcomeMsg;
    }
    
    /**
     * Prints a welcome message to standard output.
     *
     * <p>Used when starting up program.
     */
    public static void sayHello() {
        String welcomeMsg = "Hello from\n" + LOGO;
        welcomeMsg += getHelloMessage();
        UiMessage msg = new UiMessage(welcomeMsg);
        System.out.println(msg);
    }
    
    public static void askLoadStorage() {
        System.out.println(new UiMessage("There seems to be an existing task list. Would you like to load from disk?\n"
                            + "Enter `y` to load and `n` to start a new list."));
    }
    
    public static void printError(Exception e) {
        System.out.println(e);
    }
    
    public static void askValidInput() {
        System.out.println(new UiMessage("I did not recognise that input. Please enter a valid input."));
    }
    
    public static void reportInitializeSuccess() {
        System.out.println(new UiMessage("Your task list has be initialized successfully."));
    }
    
    /**
     * Prints a goodbye message to standard output.
     *
     * <p>Used when closing program.
     */
    public static void sayGoodbye() {
        System.out.println(new UiMessage("Awwww... Sad to see you go :( Hope to see you again soon!"));
    }
}
