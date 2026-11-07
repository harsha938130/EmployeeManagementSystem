
package com.employee;

public class Employee {

    private int id;
    private String name;
    private String email;
    private double salary;

    // Constructor for adding a new employee
    public Employee(String name, String email, double salary) {
        setName(name);
        setEmail(email);
        setSalary(salary);
    }

    // Constructor for an employee already in the database
    public Employee(int id, String name, String email, double salary) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Employee ID must be greater than zero!");
        }

        this.id = id;
        setName(name);
        setEmail(email);
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Name cannot be empty!");
        }

        name = name.trim();

        if (name.length() > 100) {
            throw new IllegalArgumentException(
                    "Name cannot exceed 100 characters!");
        }

        if (!name.matches("[\\p{L}][\\p{L} .'-]*")) {
            throw new IllegalArgumentException(
                    "Name must contain valid name characters!");
        }

        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException(
                    "Email cannot be empty!");
        }

        email = email.trim();

        if (email.length() > 100) {
            throw new IllegalArgumentException(
                    "Email cannot exceed 100 characters!");
        }

        if (!email.matches(
                "^[A-Za-z0-9_+.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException(
                    "Enter a valid email address!");
        }

        this.email = email;
    }

    public void setSalary(double salary) {
        if (!Double.isFinite(salary) || salary <= 0) {
            throw new IllegalArgumentException(
                    "Salary must be greater than zero!");
        }

        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Salary: " + salary);
        System.out.println("-------------------------");
    }
}
