import java.util.List;
import java.util.ArrayList;

public class TaskList {
    protected static List<Task> tasks = new ArrayList<>();

    public static void setup(String data) {
        if (data.length() == 0) {
            return;
        }
        String[] list = data.split("\n");
        for (int i = 0; i < list.length; ++i) {
            String[] recArr = list[i].split(" | ");
            switch (recArr[0]) {
                case "T":
                    TaskList.addTask(recArr[0], recArr[2], 0);
                    break;
                case "D":
                case "E":
                    TaskList.addTask(recArr[0], recArr[2], recArr[3], 0);
                    break;
                default:
                    break;
            }
        }
    }

    public static void addTask(Task t) {
        tasks.add(t);
    }

    public static void addTask(String type, String taskName, int isDone) {
        if (taskName.length() > 0 && type.equals("T")) {
            tasks.add(Todo.createTodo(taskName, isDone == 1 ? true : false));
        }
    }

    public static void addTask(String type, String taskName, String time, int isDone) {
        if (taskName.length() > 0) {
            if (type.equals("D")) {
                tasks.add(Deadline.createDeadline(taskName, time, isDone == 1  ? true : false));
            } else if (type.equals("E")) {
                tasks.add(Event.createEvent(taskName, time, isDone == 1  ? true : false));
            }
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

    public static String list() {
        if (tasks.size() > 0) {
            String output = "    " + ((1) + ". " + tasks.get(0));
            for (int i = 1; i < tasks.size(); ++i) {
                output += "\n    ";
                output += ((i + 1) + ". " + tasks.get(i));
            }
            return output;
        } else {
            return "    No tasks.";
        }
    }

    public static boolean printList() {
        if (tasks.size() == 0) {
            System.out.println(Parser.parse("There are currently no tasks. Why not add some?"));
            return false;
        }
        String output = "Tasks in your list:\n";
        output += list();
        System.out.println(Parser.parse(output));
        return true;
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