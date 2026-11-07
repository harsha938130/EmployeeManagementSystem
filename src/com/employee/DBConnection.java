package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/employee_db";
        String username = "root";
        String password = System.getenv("DB_PASSWORD");

        if (password == null || password.isEmpty()) {
            throw new SQLException("DB_PASSWORD environment variable is missing!");
        }

        Connection connection = DriverManager.getConnection(
                url,
                username,
                password
        );

//        System.out.println("Database connected successfully!");

        return connection;
    }
}