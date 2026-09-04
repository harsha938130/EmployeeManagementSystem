package com.employee;

import java.util.ArrayList;

public class EmployeeService {

    private ArrayList<Employee> employees = new ArrayList<>();

    // Add employee
    public void addEmployee(Employee employee) {

        employees.add(employee);

        System.out.println("Employee added successfully!");
    }

    // View all employees
    public void viewEmployees() {

        if (employees.isEmpty()) {

            System.out.println("No employees found.");

            return;
        }

        for (Employee employee : employees) {

            employee.displayEmployee();
        }
    }

    // Search employee
    public void searchEmployee(int id) {

        for (Employee employee : employees) {

            if (employee.getId() == id) {

                employee.displayEmployee();

                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // Update employee
    public void updateEmployee(
            int id,
            String name,
            String email,
            double salary) {

        for (Employee employee : employees) {

            if (employee.getId() == id) {

                employee.setName(name);
                employee.setEmail(email);
                employee.setSalary(salary);

                System.out.println("Employee updated successfully!");

                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // Delete employee
    public void deleteEmployee(int id) {

        for (Employee employee : employees) {

            if (employee.getId() == id) {

                employees.remove(employee);

                System.out.println("Employee deleted successfully!");

                return;
            }
        }

        System.out.println("Employee not found.");
    }
}