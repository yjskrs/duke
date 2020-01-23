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
            for (int i = 0; i < tasks.size(); ++i) {
                System.out.println(Parser.parse((i + 1) + ". " + tasks.get(i));
            }
        } else {
            return false;
        }
    }
}
