package duke;

import java.util.List;
import java.util.ArrayList;

public class TaskList {
    private static List<Task> tasks = new ArrayList<>();

    public static void setup(String data) {
        if (data.length() == 0) {
            return;
        }
        String[] list = data.split("\n");
        for (int i = 0; i < list.length; ++i) {
            if (list[i].length() == 0) {
                continue;
            }

            String[] recArr = list[i].strip().split(" \\| ");
            switch (recArr[0]) {
            case "T":
                TaskList.addTask(Todo.createTodo(recArr[2], recArr[1].equals("1") ? true : false));
                break;
            case "D":
                TaskList.addTask(Deadline.createDeadline(recArr[2], recArr[3], recArr[1].equals("1") ? true : false));
                break;
            case "E":
                TaskList.addTask(Event.createEvent(recArr[2], recArr[3], recArr[1].equals("1") ? true : false));
                break;
            default:
                break;
            }
        }
    }

    public static String addTask(Task t) {
        tasks.add(t);
        return "Added:\n" + t.toString();
    }

    public static String doTask(int i) {
        if (i <= 0 || i > tasks.size()) {
            return "This task doesn't exist.";
        } else {
            tasks.get(i-1).setDone();
            return "Good job for completing the task:\n" + tasks.get(i-1);
        }
    }

    public static String undoTask(int i) {
        if (i <= 0 || i > tasks.size()) {
            return"This task doesn't exist.";
        } else {
            tasks.get(i-1).resetDone();
            return "o.o well... good luck completing the task:\n" + tasks.get(i-1);
        }
    }

    public static String removeTask(int i) {
        if (i <= 0 || i > tasks.size()) {
            return "This task doesn't exist.";
        } else {
            tasks.remove(i-1);
            return "Removed task:" + "\n    " + tasks.get(i-1);
        }
    }

    public static String list() {
        if (tasks.size() > 0) {
            String output = (1) + ". " + tasks.get(0);
            for (int i = 1; i < tasks.size(); ++i) {
                output += "\n";
                output += ((i + 1) + ". " + tasks.get(i));
            }
            return output;
        } else {
            return "No tasks.";
        }
    }

    public static String format() {
        String formattedTasksList = "";
        for (int i = 0; i < tasks.size(); ++i) {
            formattedTasksList += tasks.get(i).format();
            formattedTasksList += "\n";
        }
        return formattedTasksList;
    }
}