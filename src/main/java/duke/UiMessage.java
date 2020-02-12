package duke;

public class UiMessage {
    private static final String LINE_SEPARATOR = "____________________________________________________________";
    private static final String INDENTATION = "    ";
    private static final String NEW_LINE = "\n";
    
    private String message;
    
    protected UiMessage(String message) {
        this.message = message;
    }
    
    /**
     * Handles program output and formats it for printing to standard output.
     *
     * @return The string to be printed to standard output.
     */
    public String parseMessage() {
        if (message.isEmpty()) {
            return "";
        }
        
        String formattedOutput = LINE_SEPARATOR + NEW_LINE + message + NEW_LINE + LINE_SEPARATOR;
        String[] outputArr = formattedOutput.split(NEW_LINE);
        
        String indentedOutput = "";
        for (String line : outputArr) {
            if (!line.isEmpty()) {
                indentedOutput += (INDENTATION + line.strip() + NEW_LINE);
            }
        }
        return indentedOutput;
    }
    
    @Override
    public String toString() {
        return parseMessage();
    }
}
