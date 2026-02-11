import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Custom exception for invalid task input (bonus)
class InvalidTaskException extends Exception {
    public InvalidTaskException(String message) {
        super(message);
    }
}

public class TaskManager {
    private final List<String> arrayTasks;
    private final List<String> linkedTasks;

    public TaskManager() {
        this.arrayTasks = new ArrayList<>();
        this.linkedTasks = new LinkedList<>();
    }

    // Add task to both lists
    public void addTask(String task) throws InvalidTaskException {
        if (task == null || task.trim().isEmpty()) {
            throw new InvalidTaskException("Task cannot be null or empty.");
        }
        String cleanTask = task.trim();
        arrayTasks.add(cleanTask);
        linkedTasks.add(cleanTask);
        System.out.println("Task added: " + cleanTask);
    }

    // Sort tasks alphabetically
    public void sortTasks() {
        if (arrayTasks.isEmpty()) {
            System.out.println("No tasks to sort.");
            return;
        }
        Collections.sort(arrayTasks);
        Collections.sort(linkedTasks);
        System.out.println("Tasks sorted alphabetically.");
    }

    // Search for a task
    public int searchTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            System.out.println("Error: Invalid task!");
            return -1;
        }
        int index = arrayTasks.indexOf(task.trim());
        if (index != -1) {
            System.out.println("Task found at index: " + index);
        } else {
            System.out.println("Task not found.");
        }
        return index;
    }

    // Remove a task
    public void removeTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            System.out.println("Error: Invalid task!");
            return;
        }
        boolean removedArray = arrayTasks.remove(task.trim());
        boolean removedLinked = linkedTasks.remove(task.trim());
        if (removedArray && removedLinked) {
            System.out.println("Task removed: " + task.trim());
        } else {
            System.out.println("Task not found.");
        }
    }

    // Find the longest task
    public String findLongestTask() {
        if (arrayTasks.isEmpty()) {
            System.out.println("No tasks available.");
            return null;
        }
        String longest = arrayTasks.get(0);
        for (String task : arrayTasks) {
            if (task.length() > longest.length()) {
                longest = task;
            }
        }
        System.out.println("Longest task: " + longest);
        return longest;
    }

    // Retrieve task by index
    public String getTaskByIndex(int index) {
        try {
            String task = arrayTasks.get(index);
            System.out.println("Task at index " + index + ": " + task);
            return task;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index!");
            return null;
        } finally {
            System.out.println("Index lookup finished.");
        }
    }

    // Display all tasks
    public void displayTasks() {
        if (arrayTasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("All tasks (" + arrayTasks.size() + " total): " + arrayTasks);
    }
}