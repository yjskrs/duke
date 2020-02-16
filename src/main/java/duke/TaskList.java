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
    
    /**
     * Create empty TaskList object.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }
    
    /**
     * Create TaskList object with initial value.
     *
     * @param tasks Tasks loaded from file.
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    /**
     * Gets a task by its id (index + 1).
     *
     * @param id Id of task that user sees.
     * @return The task.
     * @throws IndexOutOfBoundsException If fed invalid id.
     */
    public Task getTask(int id) throws IndexOutOfBoundsException {
        int index = id - 1;
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException();
        }
        return tasks.get(index);
    }
    
    /**
     * Adds a task to the list.
     *
     * @param newTask The task to be added.
     */
    public void add(Task newTask) {
        tasks.add(newTask);
    }
    
    /**
     * Removes a task from the list.
     *
     * @param id The id of the task to be removed.
     * @return The task removed.
     * @throws IndexOutOfBoundsException If fed invalid id.
     */
    public Task remove(int id) throws IndexOutOfBoundsException {
        Task task = getTask(id);
        tasks.remove(task);
        return task;
    }
    
    /**
     * Marks a task as completed.
     *
     * @param id The id of the task to be modified.
     * @return The task modified.
     * @throws IndexOutOfBoundsException If fed invalid id.
     */
    public Task markAsCompleted(int id) throws IndexOutOfBoundsException {
        Task task = getTask(id);
        task.markAsCompleted();
        return task;
    }
    
    /**
     * Marks a task as incomplete.
     *
     * @param id The id of the task to be modified.
     * @return The task modified.
     * @throws IndexOutOfBoundsException If fed invalid id.
     */
    public Task markAsIncomplete(int id) throws IndexOutOfBoundsException {
        Task task = getTask(id);
        task.markAsIncomplete();
        return task;
    }
    
    /**
     * Lists all tasks in the list.
     *
     * @return String representing the list of tasks.
     */
    public String list() {
        if (tasks.isEmpty()) {
            return "There are no tasks!";
        }
        
        String output = "";
        for (int i = 0; i < tasks.size(); ++i) {
            int id = i + 1;
            output += (id + " " + tasks.get(i) + "\n");
        }
        return output;
    }
    
    /**
     * Finds an array of tasks that match the string provided. Returns null if there are no
     * matching tasks.
     *
     * @param name The name of task to find.
     * @return Task array, if found, or null if no matching tasks found.
     */
    public Task[] find(String name) {
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