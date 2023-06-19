package com.estudos;

import com.estudos.repository.DatabaseConnection;

public class Main {
    public static void main(String[] args) {

        DatabaseConnection connection  = DatabaseConnection.getInstance();
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        DatabaseConnection connection3 = DatabaseConnection.getInstance();
        DatabaseConnection connection4 = DatabaseConnection.getInstance();
        DatabaseConnection connection5 = DatabaseConnection.getInstance();

        System.out.println(connection);
        System.out.println(connection1);
        System.out.println(connection2);
        System.out.println(connection3);
        System.out.println(connection4);
        System.out.println(connection5);

    }
}