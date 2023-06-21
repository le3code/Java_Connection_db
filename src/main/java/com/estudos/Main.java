package com.estudos;

import com.estudos.domain.Client;
import com.estudos.repository.ClientRepository;
import com.mysql.cj.jdbc.interceptors.ConnectionLifecycleInterceptor;
import jdk.jshell.spi.SPIResolutionException;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


        ClientRepository clientRepository = new ClientRepository();

        /*
        // insert no  banco
        Client client = new Client();
        client.setFirstName("Hana liz");
        client.setLastName("Sousa");
        client.setCpf("987654321-04");
        client.setEmail("hana@hana");
        client.setAge(01);

        clientRepository.insert(client);
        */


        // update
        Client clientUpdate = new Client();
        clientUpdate.setId(4);
        clientUpdate.setFirstName("Hanna Lizz");
        clientUpdate.setLastName("Lopes de Sousa");
        clientUpdate.setCpf("987654321-04");
        clientUpdate.setEmail("hanna@hanna");
        clientUpdate.setAge(01);

        clientRepository.update(clientUpdate);

        // reader ler todo os dados
        clientRepository.findAll().forEach(System.out::println);
        //--------------------------------------------------------


        /*
        //  reader com fitros
        Client client = clientRepository.findById(3);
        if(client != null) {
            System.out.println(client);
        } else {
            System.out.println("Cliente não  Encontrado!");
        }
        */



    }
}