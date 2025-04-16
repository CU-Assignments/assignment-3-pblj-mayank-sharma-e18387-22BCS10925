// src/UniversityEnrollmentSystem.java
import java.util.*;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

public class UniversityEnrollmentSystem {
    static final int MAX_STUDENTS = 2;
    public static List<String> enrolledStudents = new ArrayList<>();
    static Set<String> completedCourses = new HashSet<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();

            System.out.print("Prerequisite: ");
            String prerequisite = scanner.nextLine();

            try {
                enrollStudent(course, prerequisite);
                System.out.println("Enrolled in " + course + " successfully.");
            } catch (CourseFullException | PrerequisiteNotMetException e) {
                System.out.println("Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            }
        } // Scanner auto-closes here
    }

    public static void enrollStudent(String course, String prerequisite)
            throws CourseFullException, PrerequisiteNotMetException {

        if (!completedCourses.contains(prerequisite)) {
            throw new PrerequisiteNotMetException("Complete " + prerequisite + " before enrolling in " + course + ".");
        }

        if (enrolledStudents.size() >= MAX_STUDENTS) {
            throw new CourseFullException("Course " + course + " is full.");
        }

        enrolledStudents.add(course);
    }
}
