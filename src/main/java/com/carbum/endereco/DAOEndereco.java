package com.carbum.endereco;

import com.carbum.ConexaoBanco;
import com.carbum.LoginController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOEndereco {
    private ConexaoBanco conexao;
    private String sql;

    public DAOEndereco() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.conexao = new ConexaoBanco();
    }

    public void inserirEndereco(Endereco endereco, int idPessoa) throws SQLException {
        sql = "INSERT INTO endereco (idpessoa, pais, estado, cidade, cep, rua, bairro, numero, complemento, linkgooglemaps) values (" +
                "'" + idPessoa +
                "', '" + endereco.getPais() +
                "', '" + endereco.getEstado() +
                "', '" + endereco.getCidade() +
                "', '" + endereco.getCEP() +
                "', '" + endereco.getRua() +
                "', '" + endereco.getBairro() +
                "', '" + endereco.getNumero() +
                "', '" + endereco.getComplemento() +
                "', '" + endereco.getLinkGoogleMaps() +
                "');";

        Statement stm = conexao.getConnection().createStatement();
        stm.execute(sql);
    }

    public boolean editarEndereco(Endereco endereco, int idPessoa) throws SQLException {
        sql = "UPDATE endereco SET (pais, estado, cidade, cep, rua, bairro, numero, complemento) = (?, ?, ?, ?, ?, ?, ?, ?) WHERE idpessoa = ?";
        /*sql = "UPDATE endereco SET (pais, estado, cidade, cep, rua, bairro, numero, complemento) = (" +
                "'" + endereco.getPais() +
                "', '" + endereco.getEstado() +
                "', '" + endereco.getCidade() +
                "', '" + endereco.getCEP() +
                "', '" + endereco.getRua() +
                "', '" + endereco.getBairro() +
                "', '" + endereco.getNumero() +
                "', '" + endereco.getComplemento() +
                "', '" + endereco.getLinkGoogleMaps() +
                "') WHERE idpessoa = ?" + idPessoa + ";";*/

        PreparedStatement statement = conexao.getConnection().prepareStatement(sql);
        statement.setString(1, endereco.getPais());
        statement.setString(2, endereco.getEstado());
        statement.setString(3, endereco.getCidade());
        statement.setString(4, endereco.getCEP());
        statement.setString(5, endereco.getRua());
        statement.setString(6, endereco.getBairro());
        statement.setString(7, endereco.getNumero());
        statement.setString(8, endereco.getComplemento());
        statement.setInt(9, idPessoa);
        statement.execute();

        return true;
    }
}
