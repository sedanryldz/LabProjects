package labproject4;

import java.util.ArrayList;

public class Course {

    private String courseName;
    private int capacity;

    ArrayList<Student> enrolledStudent;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        enrolledStudent = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Student> getEnrolledStudent() {
        return enrolledStudent;
    }

    public void courseInfo() {
        System.out.printf("Course: %s\nCapacity: %d\nCurrent Enrolled: %d\n", courseName, capacity, enrolledStudent.size());
        System.out.println("Enrolled Students:");

        if (enrolledStudent.isEmpty()) {
            System.out.println("- No students registered yet.");
        } else {
            for (Student s : enrolledStudent) {
                System.out.println("- " + s.getName() + " (ID: " + s.getStudentID() + ")");
            }
        }
        System.out.println("-----------------------------------");
    }

}
