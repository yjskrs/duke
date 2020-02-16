package duke;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public static final String NEWLINE = "\n";
    //    public static final String SPACE = " ";
//    public static final String PIPE = "\\|";
    public static final String SPACED_PIPE = "\\|";
    
    /**
    * Parses data (in file format) into a list of tasks.
    *
    * @param data String data from file.
    * @return List of tasks.
    */
    public static List<Task> parseDataToTask(String data) {
        System.out.println("helpppp");
        String[] array = data.split(NEWLINE);
        List<Task> tasks = new ArrayList<>();
        for (String item : array) {
        if (item.isEmpty()) {
        continue;
        }
        
        String[] itemBreakdown = item.split(SPACED_PIPE);
        String type = itemBreakdown[0].strip();
        String name = itemBreakdown[2].strip();
        boolean isCompleted = itemBreakdown[1].strip().equals("1");
        switch (type) {
            case "T":
                tasks.add(new Todo(name, isCompleted));
                break;
            case "D":
                tasks.add(new Deadline(name, isCompleted, itemBreakdown[3].strip()));
                break;
            case "E":
                tasks.add(new Event(name, isCompleted, itemBreakdown[3].strip()));
                break;
            default:
                System.out.println(itemBreakdown[0]);
                break;
            }
        }
        System.out.println(tasks);
        return tasks;
    }
}