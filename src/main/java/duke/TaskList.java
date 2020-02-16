package duke;

import java.util.ArrayList;
import java.util.List;

/**
 * The <code>TaskList</code> class stores a list of all <code>Task</code> objects and handles
 * them.
 *
 * @author Zhu Yijie
 */
public class TaskList {
    private List<Task> tasks;
    
    public TaskList() {
        this.tasks = new ArrayList<>();
    }
    
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    /**
     * Adds a task to the list.
     *
     * @param newTask The task to be added.
     */
    public void addTask(Task newTask) {
        tasks.add(newTask);
    }
    
    /**
     * Gets a task by its id (index + 1).
     *
     * @param id Id of task that user sees.
     * @return The task.
     */
    private Task getTask(int id) {
        return tasks.get(id - 1);
    }
    
    /**
     * Removes a task from the list.
     *
     * @param id The id of the task to be removed.
     * @return The task removed.
     */
    public Task removeTask(int id) {
        Task task = getTask(id);
        tasks.remove(task);
        return task;
    }
    
    /**
     * Marks a task from the list as completed.
     *
     * @param id The id of the task to be modified.
     * @return The task modified.
     */
    public Task markTaskAsCompleted(int id) {
        Task task = getTask(id);
        task.markAsCompleted();
        return task;
    }
    
    /**
     * Marks a task from the list as incomplete.
     *
     * @param id The id of the task to be modified.
     * @return The task modified.
     */
    public Task markTaskAsIncomplete(int id) {
        Task task = getTask(id);
        task.markAsIncomplete();
        return task;
    }
    
    /**
     * Finds an array of tasks that match the string provided. Returns null if there are no
     * matching tasks.
     *
     * @param name The name of task to find.
     * @return Task array, if found, or null if no matching tasks found.
     */
    public Task[] findTask(String name) {
        List<Task> tasksMatched = new ArrayList<>();
        for (Task task : tasks) {
            if (task.matchesPartOfName(name)) {
                tasksMatched.add(task);
            }
        }
        
        if (tasksMatched.isEmpty()) {
            return null;
        } else {
            return tasksMatched.toArray(Task[]::new);
        }
    }
    
    /**
     * Lists all tasks in the list.
     *
     * @return String representing the list of tasks.
     */
    public String listTasks() {
        if (tasks.isEmpty()) {
            return "There are no tasks!";
        }
        
        String output = "";
        for (int i = 0; i < tasks.size(); ++i) {
            output += ((i + 1) + ". " + tasks.get(i) + "\n");
        }
        return output;
    }
    
    /**
     * Formats the list of tasks for storing in a file.
     *
     * @return String representing the list of tasks.
     */
    public String format() {
        String formattedTaskList = "";
        for (Task task : tasks) {
            formattedTaskList += (task.format() + "\n");
        }
        return formattedTaskList;
    }
}