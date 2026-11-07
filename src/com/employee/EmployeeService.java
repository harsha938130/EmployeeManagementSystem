
package com.employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

	private final EmployeeDAO employeeDAO = new EmployeeDAO();

	// Add employee
	public void addEmployee(Employee employee) throws SQLException {

		if (employeeDAO.addEmployee(employee)) {
			System.out.println("Employee added successfully!");
		} else {
			System.out.println("Employee could not be added.");
		}
	}

	// View all employees
	public void viewEmployees() throws SQLException {

		List<Employee> employees = employeeDAO.getAllEmployees();

		if (employees.isEmpty()) {
			System.out.println("No employees found.");
			return;
		}

		for (Employee employee : employees) {
			employee.displayEmployee();
		}
	}

	// Search employee
	public void searchEmployee(int id) throws SQLException {

		Employee employee = employeeDAO.getEmployeeById(id);

		if (employee == null) {
			System.out.println("Employee not found!");
		} else {
			employee.displayEmployee();
		}
	}

	// Update employee
	public void updateEmployee(int id, String name, String email, double salary) throws SQLException {

		if (employeeDAO.getEmployeeById(id) == null) {
			System.out.println("Employee not found!");
			return;
		}

		Employee employee = new Employee(id, name, email, salary);

		if (employeeDAO.updateEmployee(employee)) {
			System.out.println("Employee updated successfully!");
		} else {
			System.out.println("Employee could not be updated.");
		}
	}

	// Delete employee
	public void deleteEmployee(int id) throws SQLException {

		if (employeeDAO.deleteEmployee(id)) {
			System.out.println("Employee deleted successfully!");
		} else {
			System.out.println("Employee not found!");
		}
	}
}