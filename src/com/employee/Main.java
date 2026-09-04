package com.employee;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	
    	DBConnection.getConnection();
    	
        Scanner scanner = new Scanner(System.in);

        EmployeeService service = new EmployeeService();

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("       EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("========================================");

            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();

                    Employee employee =
                            new Employee(id, name, email, salary);

                    service.addEmployee(employee);

                    break;

                case 2:

                    service.viewEmployees();

                    break;

                case 3:

                    System.out.print("Enter Employee ID: ");
                    int searchId = scanner.nextInt();

                    service.searchEmployee(searchId);

                    break;

                case 4:

                    System.out.print("Enter Employee ID: ");
                    int updateId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();

                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();

                    service.updateEmployee(
                            updateId,
                            newName,
                            newEmail,
                            newSalary
                    );

                    break;

                case 5:

                    System.out.print("Enter Employee ID: ");
                    int deleteId = scanner.nextInt();

                    service.deleteEmployee(deleteId);

                    break;

                case 6:

                    System.out.println(
                            "Thank you for using Employee Management System!"
                    );

                    scanner.close();

                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}