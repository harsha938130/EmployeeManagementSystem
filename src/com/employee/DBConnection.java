package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection connection = null;

        try {

            String url = "jdbc:mysql://localhost:3306/employee_db";
            String username = "root";
            String password = "Harsha$1409";

            connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Database connected successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }

        return connection;
    }
}