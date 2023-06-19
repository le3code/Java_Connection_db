package com.estudos.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;
    private static DatabaseConnection instance; //
    public static  DatabaseConnection getInstance(){
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    private DatabaseConnection() {
        //TODO
        try {
            this.createConnectio();
        } catch (SQLException e ) {
            System.out.println("SQL Error: "+ e.getMessage());
        }
    }


    private void createConnectio() throws SQLException {
        this.connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/teste", "root", "123456789");
                this.connection.setAutoCommit(true);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnectio() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("SQL Error: "+ e.getMessage());
        }
    }
}
