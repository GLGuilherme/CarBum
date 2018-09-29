package com.carbum.anuncio;

import com.carbum.ConexaoBanco;

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
        sql = "Insert into  anuncio (NomePeca, ParteCarro, descricao, conservacao, nomecarro, marcacarro, ano, modelo, imagem1) values ('"
                + AnuncioNovo.getTitulo() + "', '"
                + AnuncioNovo.getParteCarro() + "', '"
                + AnuncioNovo.getDescricao() + "', '"
                + AnuncioNovo.getConservacao() + "', '"
                + AnuncioNovo.getNomeCarro() + "', '"
                + AnuncioNovo.getMarcaCarro() + "', '"
                + AnuncioNovo.getAno() + "', '"
                + AnuncioNovo.getModelo() + "', '"
                + AnuncioNovo.getImagem1() +"');";
        Statement stm = conexao.getConnection().createStatement();
        stm.execute(sql);
        return true;
    }

}
