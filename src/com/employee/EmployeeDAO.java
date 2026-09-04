package com.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {

    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employee (name, email, salary) VALUES (?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setDouble(3, employee.getSalary());

            statement.executeUpdate();

            System.out.println("Employee added successfully!");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}