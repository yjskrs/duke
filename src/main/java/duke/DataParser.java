package duke;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public static final String NEWLINE = "\n";
    //    public static final String SPACE = " ";
//    public static final String PIPE = "\\|";
    public static final String SPACED_PIPE = " \\| ";
    
    /**
    * Parses data (in file format) into a list of tasks.
    *
    * @param data String data from file.
    * @return List of tasks.
    */
    public static List<Task> parseDataToTask(String data) {
        String[] array = data.split(NEWLINE);
        List<Task> tasks = new ArrayList<>();
        for (String item : array) {
            if (item.isEmpty()) {
                continue;
            }
        
            String[] itemBreakdown = item.split(SPACED_PIPE);
            String type = itemBreakdown[0];
            String name = itemBreakdown[2];
            boolean isCompleted = itemBreakdown[1].equals("1");
            switch (type) {
            case "T":
                tasks.add(new Todo(name, isCompleted));
                break;
            case "D":
                tasks.add(new Deadline(name, isCompleted, itemBreakdown[3]));
                break;
            case "E":
                tasks.add(new Event(name, isCompleted, itemBreakdown[3]));
                break;
            default:
                break;
            }
        }
        return tasks;
    }
}