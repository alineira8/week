import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        Map<Integer, String> students = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Manager ===");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a student");
            System.out.println("2. Sort students by ID");
            System.out.println("3. Search for a student");
            System.out.println("4. Remove a student");
            System.out.println("5. Find student with highest ID");
            System.out.println("6. Find student with lowest ID");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter student ID: ");
                        int studentId = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        sm.addStudent(students, studentId, name);
                    }
                    case 2 -> sm.sortStudents(students);
                    case 3 -> {
                        System.out.print("Enter student ID to search: ");
                        int searchId = Integer.parseInt(scanner.nextLine().trim());
                        sm.searchStudent(students, searchId);
                    }
                    case 4 -> {
                        System.out.print("Enter student ID to remove: ");
                        int removeId = Integer.parseInt(scanner.nextLine().trim());
                        sm.removeStudent(students, removeId);
                    }
                    case 5 -> sm.findStudentWithHighestId(students);
                    case 6 -> sm.findStudentWithLowestId(students);
                    case 7 -> {
                        running = false;
                        System.out.println("Goodbye!");
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }

        scanner.close();
    }
}