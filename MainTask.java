import java.util.Scanner;

public class MainTask {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Task Manager ===");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add task");
            System.out.println("2. Display all tasks");
            System.out.println("3. Sort tasks");
            System.out.println("4. Search task");
            System.out.println("5. Remove task");
            System.out.println("6. Find longest task");
            System.out.println("7. Get task by index");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter task: ");
                        String task = scanner.nextLine();
                        try {
                            tm.addTask(task);
                        } catch (InvalidTaskException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        tm.displayTasks();
                        break;

                    case 3:
                        tm.sortTasks();
                        break;

                    case 4:
                        System.out.print("Enter task to search: ");
                        String searchTask = scanner.nextLine();
                        tm.searchTask(searchTask);
                        break;

                    case 5:
                        System.out.print("Enter task to remove: ");
                        String removeTask = scanner.nextLine();
                        tm.removeTask(removeTask);
                        break;

                    case 6:
                        tm.findLongestTask();
                        break;

                    case 7:
                        System.out.print("Enter index: ");
                        try {
                            int index = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            tm.getTaskByIndex(index);
                        } catch (Exception e) {
                            System.out.println("Error: Invalid input!");
                            scanner.nextLine(); // Clear buffer
                        }
                        break;

                    case 8:
                        running = false;
                        System.out.println("Exiting Task Manager. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose 1-8.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input!");
                scanner.nextLine(); // Clear buffer
            }
        }

        scanner.close();
    }
}