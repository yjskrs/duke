import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private static List<Task> tasks = new ArrayList<>();

    public static boolean addTask(String taskName) {
        if (taskName.length() > 0) {
            tasks.add(Task.createTask(taskName));
            return true;
        } else {
            return false;
        }
    }

    public static boolean removeTask(String taskName) {
        for (int i = 0; i < tasks.size(); ++i) {
            if (tasks.get(i).getName().equals(taskName)) {
                tasks.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean list() {
        if (tasks.size() > 0) {
            String output = "Tasks in your list:";
            for (int i = 0; i < tasks.size(); ++i) {
                output += "\n    ";
                output += ((i + 1) + ". " + tasks.get(i));
            }
            System.out.println(Parser.parse(output));
            return true;
        } else {
            System.out.println(Parser.parse("There are currently no tasks. Why not add some?"));
            return false;
        }
    }
}
