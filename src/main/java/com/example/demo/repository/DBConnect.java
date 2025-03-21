package com.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static Connection conn;

    public static Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) { // Check if the connection is null or closed
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
