package com.carbum.carro;

import com.carbum.ConexaoBanco;
import com.carbum.peca.Peca;

import java.sql.SQLException;
import java.sql.Statement;

public class DAOCarro {
    private ConexaoBanco conexao;
    private String sql;

    public DAOCarro()throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        this.conexao = new ConexaoBanco();
    }

    public ConexaoBanco getConexao() {
        return conexao;
    }

    public boolean inserirCarro(Carro CarroPeca) throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        sql = "Insert into carro (nomecarro, marcacarro, ano, modelo) values ('"
                + CarroPeca.getNomeCarro() + "', '"
                + CarroPeca.getMarca() + "', '"
                + CarroPeca.getAno() + "', '"
                + CarroPeca.getModelo() +"');";
        Statement stm = conexao.getConnection().createStatement();
        stm.execute(sql);
        return true;
    }
}
