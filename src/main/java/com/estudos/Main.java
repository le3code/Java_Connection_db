package com.estudos;

import com.estudos.domain.Client;
import com.estudos.repository.ClientRepository;
import com.mysql.cj.jdbc.interceptors.ConnectionLifecycleInterceptor;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


        ClientRepository clientRepository = new ClientRepository();
        //clientRepository.findAll().forEach(System.out::println);
        //--------------------------------------------------------

        // com fitros
        Client client = clientRepository.findById(3);
        if(client != null) {
            System.out.println(client);
        } else {
            System.out.println("Cliente não  Encontrado!");
        }



    }
}