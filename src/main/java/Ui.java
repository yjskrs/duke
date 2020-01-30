public class Ui {
    private static final String LOGO = " ____        _        \n"
        + "|  _ \\ _   _| | _____ \n"
        + "| | | | | | | |/ / _ \\\n"
        + "| |_| | |_| |   <  __/\n"
        + "|____/ \\__,_|_|\\_\\___|\n";

    public static void welcome() {
        String welcomeMsg = "Hello from\n" + LOGO;
        welcomeMsg += Parser.parse("Hello, I'm Duke!");
        System.out.println(welcomeMsg);
    }

    public static void respond(String contents) {
        System.out.println(Parser.parse(contents));
    }
}
