package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private Connection connection= null;

    public ConexaoBanco() throws InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException {
        String databaseURL= "jdbc:postgresql://localhost:5432/postgres/CarBum";
        String usuario= "postgres";
        String senha = "probikes";
        String driverName= "org.postgresql.Driver";
//Carrega o driver
        Class.forName(driverName).newInstance();
//Conecta o BD
        connection  = DriverManager.getConnection(databaseURL, usuario, senha);
    }

    public Connection getConnection() {
        return connection;
    }
}

