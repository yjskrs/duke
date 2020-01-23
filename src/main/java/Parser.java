public class Parser {
    public static String parse(String input) {
        if (input.length() > 0) {
            String output = "    ____________________________________________________________\n";
            output += "    ";
            output += input;
            output += "\n";
            output += "    ____________________________________________________________";
            return output;
        }
        return "";
    }
}
