package duke;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringParser {
    public static final String SPACE = " ";
    public static final String SPACED_PIPE = " | ";
    public static final String NEWLINE = "\n";
    
    public static String addSquareBracket(String text) {
        return "[" + text + "]";
    }
    
    public static String addRoundBracket(String text) {
        return "(" + text + ")";
    }
    
    /**
     * Format task contents into a string separated by spaces.
     *
     * @param text Task contents.
     * @return Formatted task contents.
     */
    public static String combineTaskStringWithSpace(String... text) {
        return Arrays.asList(text).stream()
                .map(content -> content.strip())
                .collect(Collectors.joining(" "));
    }
    
    /**
     * Format task contents into a string separated by spaced pipes for saving to storage.
     *
     * @param text Task contents.
     * @return Formatted task contents.
     */
    public static String combineTaskStringWithSpacedPipe(String... text) {
        return Arrays.asList(text).stream()
                .map(content -> content.strip())
                .collect(Collectors.joining(" | "));
    }
    
}
