package com.lpm.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {
    private static final String url = "jdbc:mysql://localhost:3306/xulambsdb";
    private static final String user = "root";
    private static final String pw = "root";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(url, user, pw);
                return connection;
            } else {
                return connection;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
