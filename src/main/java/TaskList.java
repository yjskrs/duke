import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private static List<String> tasks = new ArrayList<>();

    public boolean addTask(String taskName) {
        if (taskName.length() > 0) {
            tasks.add(taskName);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeTask(String taskName) {
        if (tasks.contains(taskName)) {
            return true;
        } else {
            return false;
        }
    }
}
