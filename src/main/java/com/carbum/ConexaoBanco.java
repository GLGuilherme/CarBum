package com.carbum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private Connection connection = null;

    public ConexaoBanco() throws InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException {
        System.out.println("Iniciando criação da conexão");

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            String databaseURL = "jdbc:postgresql://localhost:5432/carbum";
            String usuario = "postgres";
            String senha = "";
            String driverName = "org.postgresql.Driver";
            Class.forName(driverName).newInstance();

            connection = DriverManager.getConnection(databaseURL, usuario, senha);

            if (connection != null) {
                System.out.println("Conexão criada com sucesso");
            } else {
                System.out.println("Impossível criar conexão");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

