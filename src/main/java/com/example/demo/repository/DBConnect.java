package com.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static Connection conn;

    public static Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/demo", // Database URL
                        "root",                              // MySQL username
                        "password"                           // MySQL password
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}