package com.chen;

import java.sql.*;

public class Database {
    private final String databaseURL = "jdbc:mysql://localhost:3306/java_lab_7";
    private final String root = "root";
    private final String password = null;
    private final Connection conn;
    private final Statement statement;
    private final PreparedStatement preparedStatement;
    private final String insertQuery = "INSERT INTO employ_table (name, department, salary) VALUE(?,?,?)";

    public Database(){
        try {
            conn = DriverManager.getConnection(databaseURL, root, password);
            statement = conn.createStatement();
            preparedStatement = conn.prepareStatement(insertQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void printDatabase(){
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employ_table");
            System.out.println("=====================================");
            while(resultSet.next()){
                System.out.println(resultSet.getString(2) + " - " + resultSet.getString(3) +
                                    " - $" + resultSet.getInt(4));
            }
            System.out.println("=====================================");
        }
        catch (SQLException e) {
            System.out.println("Cannot print the database: " + e.getMessage());
            throw new RuntimeException();
        }
    }

    public void addContact(String name, String department, double salary){
        try {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, department);
            preparedStatement.setDouble(3, salary);
            preparedStatement.executeUpdate();
            System.out.println("Employee added into the system.");
        }
        catch (SQLException e) {
            System.out.println("Cannot add into the database: " + e.getMessage());
            throw new RuntimeException();
        }

    }
}
