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
    
    public static String combineTaskStringWithSpace(String... text) {
        return Arrays.asList(text).stream()
                .map(content -> content.strip())
                .collect(Collectors.joining(" "));
    }
    
    public static String combineTaskStringWithSpacedPipe(String... text) {
        return Arrays.asList(text).stream()
                .map(content -> content.strip())
                .collect(Collectors.joining(" "));
    }
    
}
