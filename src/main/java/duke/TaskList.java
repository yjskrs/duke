package duke;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;
    
    public TaskList() {
        tasks = new ArrayList<>();
    }
    
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    public Task getTask(int id) throws IndexOutOfBoundsException {
        int index = id - 1;
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException();
        }
        return tasks.get(index);
    }
    
    public String add(Task newTask) {
        tasks.add(newTask);
        return newTask.toString();
    }
    
    public String remove(int id) throws IndexOutOfBoundsException {
        Task task = getTask(id);
        tasks.remove(task);
        return task.toString();
    }
    
    public String markAsCompleted(int id) throws IndexOutOfBoundsException {
        Task task = getTask(id);
        task.markAsCompleted();
        return task.toString();
    }
    
    public String markAsIncomplete(int id) throws IndexOutOfBoundsException {
        Task task = getTask(id);
        task.markAsIncomplete();
        return task.toString();
    }
    
    public String list() {
        String output = "";
        for (int i = 0; i < tasks.size(); ++i) {
            int id = i + 1;
            output += (id + " " + tasks.get(i) + "\n");
        }
        return output;
    }
    
    public String find(String name) {
        String matches = "";
        for (Task task : tasks) {
            if (task.matchPartial(name)) {
                matches += task.toString() + "\n";
            }
        }
        return matches;
    }
    
    public String formatData() {
        String formattedTaskList = "";
        for (int i = 0; i < tasks.size(); ++i) {
            formattedTaskList += (tasks.get(i).format() + "\n");
        }
        return formattedTaskList;
    }
    
    public void clearData() {
        tasks.clear();
    }
}
