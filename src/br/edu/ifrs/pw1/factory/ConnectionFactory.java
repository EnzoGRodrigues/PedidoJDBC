package br.edu.ifrs.pw1.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public ConnectionFactory() {
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlBD = "jdbc:mysql://localhost:3306/bd";
            return DriverManager.getConnection(urlBD, "root", "");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}