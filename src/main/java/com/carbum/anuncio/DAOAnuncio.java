package com.carbum.anuncio;

import com.carbum.ConexaoBanco;
import com.carbum.TelaCadastroPecaController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOAnuncio {
    private ConexaoBanco conexao;
    private String sql;

    public DAOAnuncio()throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        this.conexao = new ConexaoBanco();
    }

    public ConexaoBanco getConexao() {
        return conexao;
    }

    public boolean inserirAnuncio(Anuncio AnuncioNovo) throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        sql = "Insert into  anuncio (NomePeca, ParteCarro, descricao, conservacao, nomecarro, marcacarro, ano, modelo) values ('"
                + AnuncioNovo.getNomePeca() + "', '"
                + AnuncioNovo.getParteCarro() + "', '"
                + AnuncioNovo.getDescricao() + "', '"
                + AnuncioNovo.getConservacao() + "', '"
                + AnuncioNovo.getNomeCarro() + "', '"
                + AnuncioNovo.getMarcaCarro() + "', '"
                + AnuncioNovo.getAno() + "', '"
                + AnuncioNovo.getModelo() + "');";
        Statement stm = conexao.getConnection().createStatement();
        stm.execute(sql);
        return true;
    }

}
