package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Syeda!");

        // Hardcoded credentials
        String username = "admin";
        String password = "password123";

        // Vulnerable SQL query
        String userInput = "admin' --";
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";

        System.out.println("Executing query: " + query);

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", username, password);
            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int result = Utils.add(5, 3);
        System.out.println("5 + 3 = " + result);
    }
}
