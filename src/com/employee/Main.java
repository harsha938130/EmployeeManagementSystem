
package com.employee;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        // Test database connection
        try (var connection = DBConnection.getConnection()) {
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            System.out.println(e.getMessage());
            scanner.close();
            return;
        }

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            int choice = readInteger(scanner, "Enter your choice: ");

            if (choice < 1 || choice > 6) {
                System.out.println("Enter a number from 1 to 6!");
                continue;
            }

            if (choice == 6) {
                System.out.println("Thank you!");
                scanner.close();
                return;
            }

            try {
                switch (choice) {

                    case 1: {
                        String name = readName(scanner, "Enter name: ");
                        String email = readEmail(scanner, "Enter email: ");
                        double salary = readSalary(scanner, "Enter salary: ");

                        Employee employee = new Employee(name, email, salary);
                        service.addEmployee(employee);
                        break;
                    }

                    case 2:
                        service.viewEmployees();
                        break;

                    case 3: {
                        int id = readPositiveId(
                                scanner, "Enter employee ID: ");
                        service.searchEmployee(id);
                        break;
                    }

                    case 4: {
                        int id = readPositiveId(
                                scanner, "Enter employee ID: ");

                        String name = readName(
                                scanner, "Enter new name: ");
                        String email = readEmail(
                                scanner, "Enter new email: ");
                        double salary = readSalary(
                                scanner, "Enter new salary: ");

                        service.updateEmployee(id, name, email, salary);
                        break;
                    }

                    case 5: {
                        int id = readPositiveId(
                                scanner, "Enter employee ID: ");
                        service.deleteEmployee(id);
                        break;
                    }
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid data: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }

    private static int readInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number!");
            }
        }
    }

    private static int readPositiveId(Scanner scanner, String prompt) {
        while (true) {
            int id = readInteger(scanner, prompt);

            if (id > 0) {
                return id;
            }

            System.out.println("ID must be greater than zero!");
        }
    }

    private static String readName(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String name = scanner.nextLine();

            try {
                new Employee(name, "check@example.com", 1);
                return name.trim();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readEmail(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String email = scanner.nextLine();

            try {
                new Employee("Check Name", email, 1);
                return email.trim();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double readSalary(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                double salary = Double.parseDouble(input);

                if (!Double.isFinite(salary) || salary <= 0) {
                    System.out.println(
                            "Salary must be a positive number!");
                    continue;
                }

                return salary;

            } catch (NumberFormatException e) {
                System.out.println(
                        "Please enter a valid numeric salary!");
            }
        }
    }
}