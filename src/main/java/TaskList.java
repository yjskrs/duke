import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private static List<Task> tasks = new ArrayList<>();

    public static Task getLastTaskAdded() {
        return tasks.get(tasks.size() - 1);
    }

    public static boolean addTask(String type, String taskName) {
        if (taskName.length() > 0 && type.equals("T")) {
            tasks.add(Todo.createTodo(taskName));
            return true;
        } else {
            return false;
        }
    }

    public static boolean addTask(String type, String taskName, String time) {
        if (taskName.length() > 0) {
            if (type.equals("D")) {
                tasks.add(Deadline.createDeadline(taskName, time));
            } else if (type.equals("E")) {
                tasks.add(Event.createEvent(taskName, time));
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean addTask(String type, String taskName, int isDone) {
        if (taskName.length() > 0 && type.equals("T")) {
            tasks.add(Todo.createTodo(taskName, isDone == 1 ? true : false));
            return true;
        } else {
            return false;
        }
    }

    public static boolean addTask(String type, String taskName, String time, int isDone) {
        if (taskName.length() > 0) {
            if (type.equals("D")) {
                tasks.add(Deadline.createDeadline(taskName, time, isDone == 1 ? true : false));
            } else if (type.equals("E")) {
                tasks.add(Event.createEvent(taskName, time, isDone == 1 ? true : false));
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean doTask(int i) {
        if (i <= 0 || i > tasks.size()) {
            System.out.println(Parser.parse("This task doesn't exist."));
            return false;
        } else {
            tasks.get(i-1).setDone();
            System.out.println(Parser.parse("Good job for completing the task:" + "\n    " + tasks.get(i-1)));
            return true;
        }
    }

    public static boolean undoTask(int i) {
        if (i <= 0 || i > tasks.size()) {
            System.out.println(Parser.parse("This task doesn't exist."));
            return false;
        } else {
            tasks.get(i-1).resetDone();
            System.out.println(Parser.parse("o.o well... good luck completing the task:" + "\n    " + tasks.get(i-1)));
            return true;
        }
    }

    public static boolean removeTask(int i) {
        if (i <= 0 || i > tasks.size()) {
            System.out.println(Parser.parse("This task doesn't exist."));
            return false;
        } else {
            System.out.println(Parser.parse("removed task:" + "\n    " + tasks.get(i-1)));
            tasks.remove(i-1);
            return true;
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

    public static String format() {
        String formattedTasksList = "";
        for (int i = 0; i < tasks.size(); ++i) {
            formattedTasksList += tasks.get(i).format();
            formattedTasksList += "\n";
        }
        return formattedTasksList;
    }
}
