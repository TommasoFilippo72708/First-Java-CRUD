
package pl.edu.vistula;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Student {
        int id;
        String name;
        String email;

        Student(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "ID: " + id
                    + " | Name: " + name
                    + " | Email: " + email;
        }
    }

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add student");
            System.out.println("2. List students");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addStudent();
                case "2" -> listStudents();
                case "3" -> updateStudent();
                case "4" -> deleteStudent();
                case "0" -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        students.add(new Student(nextId++, name, email));
        System.out.println("Student added successfully!");
    }

    static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = readId();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name: ");
        student.name = scanner.nextLine();

        System.out.print("Enter new email: ");
        student.email = scanner.nextLine();

        System.out.println("Student updated successfully!");
    }

    static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = readId();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);
        System.out.println("Student deleted successfully!");
    }

    static Student findStudent(int id) {
        for (Student student : students) {
            if (student.id == id) {
                return student;
            }
        }

        return null;
    }

    static int readId() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid numeric ID: ");
            }
        }
    }
}
