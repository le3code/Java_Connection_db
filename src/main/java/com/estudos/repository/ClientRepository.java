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
    public Client findById(int id) throws SQLException {
        Client client = null;
        PreparedStatement preparedStatement = this.connection
                .getConnection().prepareStatement("SELECT * FROM client WHERE id =?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if( resultSet.next()) {

            client = new Client();

            client.setId(resultSet.getInt("id"));
            client.setFirstName(resultSet.getString("firstName"));
            client.setLastName(resultSet.getString("lastName"));
            client.setCpf(resultSet.getString("cpf"));
            client.setEmail(resultSet.getString("email"));
            client.setAge(resultSet.getInt("age"));
        }

        return client;
    }

    public Boolean insert(Client client) throws SQLException {
        boolean insertd =  false;

        String insertSQL = "INSERT INTO client (firstName, lastName, cpf, email, age)"+
                "values(?,?,?,?,?)";

        PreparedStatement preparedStatement = this.connection
                .getConnection()
                .prepareStatement(insertSQL);

        preparedStatement.setString(1, client.getFirstName());
        preparedStatement.setString(2, client.getLastName());
        preparedStatement.setString(3, client.getCpf());
        preparedStatement.setString(4, client.getEmail());
        preparedStatement.setInt(5, client.getAge());


        insertd = preparedStatement.execute();

        return insertd;
    }

    public Boolean update(Client client) throws SQLException {
        boolean updated = false;

        if ( client == null || client.getId() <= 0  ) {
            return false;
        }
        String updateSQL = "UPDATE client "+
                "SET firstName = ?, "+
                "lastName = ?,"+
                "cpf = ?,"+
                "email =?,"+
                "age = ? "+
                "WHERE id = ?";

        PreparedStatement preparedStatement =  this.connection
                .getConnection()
                .prepareStatement(updateSQL);

        preparedStatement.setString(1,client.getFirstName());
        preparedStatement.setString(2,client.getLastName());
        preparedStatement.setString(3,client.getCpf());
        preparedStatement.setString(4,client.getEmail());
        preparedStatement.setInt(5,client.getAge());
        preparedStatement.setInt(6,client.getId());

        updated = preparedStatement.execute();

        return updated;
    }




}
