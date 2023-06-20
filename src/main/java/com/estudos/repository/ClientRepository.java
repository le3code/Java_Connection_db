package com.estudos.repository;
import com.estudos.domain.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private DatabaseConnection connection;

    public ClientRepository() {
        this.connection = DatabaseConnection.getInstance();
    }

    public List<Client> findAll() throws SQLException {
        List<Client> clients = new ArrayList<>();


        PreparedStatement preparedStatement = this.connection
                .getConnection().prepareStatement("SELECT * FROM client");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getInt("id"));
            client.setFirstName(resultSet.getString("firstName"));
            client.setLastName(resultSet.getString("lastName"));
            client.setCpf(resultSet.getString("cpf"));
            client.setEmail(resultSet.getString("email"));
            client.setAge(resultSet.getInt("age"));
            clients.add(client);

        }
        return clients;
    }




}
