import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private static List<String> tasks = new ArrayList<>();

    public static boolean addTask(String taskName) {
        if (taskName.length() > 0) {
            tasks.add(taskName);
            return true;
        } else {
            return false;
        }
    }

    public static boolean removeTask(String taskName) {
        if (tasks.contains(taskName)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean list() {
        if (tasks.size() > 0) {
            String output = ("1. " + tasks.get(0));
            for (int i = 1; i < tasks.size(); ++i) {
                output += "\n    ";
                output += ((i + 1) + ". " + tasks.get(i));
            }
            System.out.println(Parser.parse(output));
            return true;
        } else {
            return false;
        }
    }
}
