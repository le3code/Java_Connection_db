package com.estudos;

import com.estudos.repository.ClientRepository;
import com.estudos.repository.DatabaseConnection;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        //
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.findAll().forEach(System.out::println);
    }
}