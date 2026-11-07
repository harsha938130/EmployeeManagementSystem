package com.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // Create/add employee's

public boolean addEmployee(Employee employee) throws SQLException {

    String sql = "INSERT INTO employee (name, email, salary) "
               + "VALUES (?, ?, ?)";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, employee.getName());
        statement.setString(2, employee.getEmail());
        statement.setDouble(3, employee.getSalary());

        return statement.executeUpdate() == 1;
    }
}

    // Read all employees
    public List<Employee> getAllEmployees() throws SQLException {

        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT id, name, email, salary "
                   + "FROM employee ORDER BY id";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getDouble("salary")
                ));
            }
        }

        return employees;
    }

    // Read one
    public Employee getEmployeeById(int id) throws SQLException {

        String sql = "SELECT id, name, email, salary "
                   + "FROM employee WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Employee(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getDouble("salary")
                    );
                }
            }
        }

        return null;
    }

    // Update
    public boolean updateEmployee(Employee employee) throws SQLException {

        String sql = "UPDATE employee "
                   + "SET name = ?, email = ?, salary = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setDouble(3, employee.getSalary());
            statement.setInt(4, employee.getId());

            return statement.executeUpdate() == 1;
        }
    }

    // Delete
    public boolean deleteEmployee(int id) throws SQLException {

        String sql = "DELETE FROM employee WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            return statement.executeUpdate() == 1;
        }
    }
}