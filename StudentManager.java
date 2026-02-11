import java.util.Map;
import java.util.TreeMap;

public class StudentManager {

    // Add a student to the map
    public void addStudent(Map<Integer, String> students, int studentId, String name) {
        try {
            if (studentId <= 0) {
                throw new IllegalArgumentException("Student ID cannot be negative!");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Student name cannot be empty!");
            }
            if (students == null) {
                throw new NullPointerException("Student map is null.");
            }

            students.put(studentId, name.trim());
            System.out.println("Student added: ID = " + studentId + ", Name = " + name.trim());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            String message = e.getMessage();
            if (message == null || message.isBlank()) {
                System.out.println("Error: Null key or value found.");
            } else {
                System.out.println("Error: " + message);
            }
        }
    }

    // Sort students by ID using TreeMap
    public void sortStudents(Map<Integer, String> students) {
        try {
            if (students == null) {
                throw new NullPointerException("Student map is null.");
            }
            if (students.isEmpty()) {
                System.out.println("No students to sort.");
                return;
            }
            TreeMap<Integer, String> sortedStudents = new TreeMap<>(students);
            System.out.println("Students sorted by ID:");
            for (Map.Entry<Integer, String> entry : sortedStudents.entrySet()) {
                System.out.println("  ID: " + entry.getKey() + " | Name: " + entry.getValue());
            }
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Search for a student by ID
    public String searchStudent(Map<Integer, String> students, int studentId) {
        try {
            if (students == null) {
                throw new NullPointerException("Student map is null.");
            }
            if (students.containsKey(studentId)) {
                String name = students.get(studentId);
                System.out.println("Student found: ID = " + studentId + ", Name = " + name);
                return name;
            } else {
                System.out.println("Student with ID " + studentId + " not found.");
                return null;
            }
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    // Remove a student by ID
    public void removeStudent(Map<Integer, String> students, int studentId) {
        try {
            if (students == null) {
                throw new NullPointerException("Student map is null.");
            }
            if (students.containsKey(studentId)) {
                String name = students.remove(studentId);
                System.out.println("Student removed: ID = " + studentId + ", Name = " + name);
            } else {
                System.out.println("Student with ID " + studentId + " not found.");
            }
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Find student with highest ID
    public void findStudentWithHighestId(Map<Integer, String> students) {
        try {
            if (students == null) {
                throw new NullPointerException("Student map is null.");
            }
            if (students.isEmpty()) {
                System.out.println("No students found.");
                return;
            }

            TreeMap<Integer, String> sortedStudents = new TreeMap<>(students);
            int highestId = sortedStudents.lastKey();
            System.out.println("Highest ID: " + highestId + ", Name: " + sortedStudents.get(highestId));
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Find student with lowest ID
    public void findStudentWithLowestId(Map<Integer, String> students) {
        try {
            if (students == null) {
                throw new NullPointerException("Student map is null.");
            }
            if (students.isEmpty()) {
                System.out.println("No students found.");
                return;
            }

            TreeMap<Integer, String> sortedStudents = new TreeMap<>(students);
            int lowestId = sortedStudents.firstKey();
            System.out.println("Lowest ID: " + lowestId + ", Name: " + sortedStudents.get(lowestId));
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}