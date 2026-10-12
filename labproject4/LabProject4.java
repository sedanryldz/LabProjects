package labproject4;

import java.util.ArrayList;
import java.util.Scanner;

public class LabProject4 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Course> liste = new ArrayList<>();

        while (true) {
            System.out.print("Enter course number: ");
            int number = input.nextInt();

            if (number < 3) {
                System.out.println("Enter at least 3 courses!");
            } else {
                for (int i = 0; i < number; i++) {
                    System.out.print("Course Name: ");
                    String courseName = input.next();
                    System.out.print("Capacity: ");
                    int capacity = input.nextInt();

                    liste.add(new Course(courseName, capacity));
                }
                break;
            }

        }

        System.out.println("--------Avaliable Courses---------");
        for (int i = 0; i < liste.size(); i++) {
            System.out.printf("Course: %s | Capacity: %d\n", liste.get(i).getCourseName(), liste.get(i).getCapacity());
        }

        System.out.println("--------MENU--------");
        String var = "Registration -> 1 \n"
                + "View All Courses -> 2\n"
                + "Exit -> -1";
        System.out.println(var);

        boolean value = true;

        while (value) {
            System.out.print("Option: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Student Name: ");
                    String sname = input.next();
                    System.out.print("Student ID: ");
                    String sID = input.next();
                    System.out.print("Course name for register: ");
                    String cname = input.next();

                    Student s = new Student(sID, sname);
                    boolean courseFound = false;

                    for (int i = 0; i < liste.size(); i++) {
                        Course currentCourse = liste.get(i);

                        if (cname.equals(currentCourse.getCourseName())) {
                            courseFound = true;

                            if (currentCourse.getEnrolledStudent().size() >= currentCourse.getCapacity()) {
                                System.out.println("This course is full. Registration failed.");
                                break;
                            }

                            boolean isDuplicate = false;
                            for (Student enrolled : currentCourse.getEnrolledStudent()) {
                                if (enrolled.getStudentID().equals(sID)) {
                                    isDuplicate = true;
                                    break;
                                }
                            }

                            if (isDuplicate) {
                                System.out.println("This student is already registered for this course.");
                                break;
                            }

                            currentCourse.getEnrolledStudent().add(s);
                            System.out.println("Registration successful.");
                            break;
                        }
                    }

                    if (!courseFound) {
                        System.out.println("No course found with that name.");
                    }

                    break;
                case 2:
                    for (int i = 0; i < liste.size(); i++) {
                        liste.get(i).courseInfo();
                    }
                    break;
                case -1:
                    System.out.println("The system is terminated!");
                    value = false;
                    break;
                default:
                    System.out.println("Invalid expression!");
                    break;

            }
        }

    }

}
