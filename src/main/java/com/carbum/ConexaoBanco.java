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
            String senha = "gabrielopes";
            String driverName = "org.postgresql.Driver";
            Class.forName(driverName).newInstance();

            connection = DriverManager.getConnection(databaseURL, usuario, senha);

            if (connection != null) {
                System.out.println("connection created successfully using properties file");
            } else {
                System.out.println(" unable to create connection");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

