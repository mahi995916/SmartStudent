package UI.java;
import java.util.Scanner;

import Main.java.StudentDAO;

public class UI {

    Scanner sc = new Scanner(System.in);
    StudentDAO dao = new StudentDAO();

    public void start() {

        int choice;

        do {

            System.out.println("\n========== SMART STUDENT MANAGEMENT ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Search by Department");
            System.out.println("7. Search by Marks");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {

                case 1:
                    // Add Student
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    // Update Student
                    break;

                case 4:
                    // Delete Student
                    break;

                case 5:
                    // Search by Roll Number
                    break;

                case 6:
                    // Search by Department
                    break;

                case 7:
                    // Search by Marks
                    break;

                case 8:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 8);
    }
}