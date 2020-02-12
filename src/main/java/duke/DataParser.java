package duke;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public static final String NEWLINE = "\n";
//    public static final String SPACE = " ";
    public static final String PIPE = "\\|";
    
    public static List<Task> parseToTask(String data) throws InvalidFormatException {
        List<Task> tasks = new ArrayList<>();
        String[] array = data.split(NEWLINE);
        for (String line : array) {
            if (line.isEmpty()) {
                continue;
            }
            
            String[] item = line.strip().split(PIPE);
            try {
                String name = item[2];
                boolean isCompleted = item[1].equals("1");
                String type = item[0];
                switch (type) {
                case "T":
                    tasks.add(new Todo(name, isCompleted));
                    break;
                case "D":
                    tasks.add(new Deadline(name, isCompleted, item[3]));
                    break;
                case "E":
                    tasks.add(new Event(name, isCompleted, item[3]));
                    break;
                default:
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidFormatException("Invalid file input format.");
            }
        }
        return tasks;
    }
}
