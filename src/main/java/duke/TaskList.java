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
            String name = recArr[2];
            boolean isCompleted = recArr[1].equals("1");
            switch (recArr[0]) {
            case "T":
                addTask(Todo.create(name, isCompleted));
                break;
            case "D":
                addTask(Deadline.create(name, isCompleted, recArr[3]));
                break;
            case "E":
                addTask(Event.create(name, isCompleted, recArr[3]));
                break;
            default:
                break;
            }
        }
    }

    public static void addTask(Task newTask) {
        tasks.add(newTask);
    }

    public static Task removeTask(int number) {
        Task task = tasks.get(number - 1);
        tasks.remove(number - 1);
        return task;
    }

    public static Task markTaskAsCompleted(int number) {
        tasks.get(number - 1).markAsCompleted();
        return tasks.get(number - 1);
    }

    public static Task markTaskAsIncomplete(int number) {
        tasks.get(number - 1).markAsIncomplete();
        return tasks.get(number - 1);
    }

    public static Task[] findTask(String name) {
        List<Task> tasksMatched = new ArrayList<>();
        for (int i = 0; i < tasks.size(); ++i) {
            if (tasks.get(i).matchesPartOfName(name)) {
                tasksMatched.add(tasks.get(i));
            }
        }
        if (tasksMatched.size() == 0) {
            return null;
        } else {
            return tasksMatched.toArray(Task[]::new);
        }
    }

    public static String listTasks() {
        if (tasks.size() == 0) {
            return "There are no tasks!";
        }
        
        String output = "";
        for (int i = 0; i < tasks.size(); ++i) {
            output += ((i + 1) + ". " + tasks.get(i) + "\n");
        }
        return output;
    }

    public static String format() {
        String formattedTaskList = "";
        for (int i = 0; i < tasks.size(); ++i) {
            formattedTaskList += (tasks.get(i).format() + "\n");
        }
        return formattedTaskList;
    }
}