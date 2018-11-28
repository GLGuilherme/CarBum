package com.carbum.anuncio;

import com.carbum.ConexaoBanco;

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
        sql = "Insert into  anuncio (ParteCarro, descricao, conservacao, nomecarro, marcacarro, ano, modelo, imagem1, imagem2, preco, idpessoa, anunciovip) values ('"
                + AnuncioNovo.getParteCarro() + "', '"
                + AnuncioNovo.getDescricao() + "', '"
                + AnuncioNovo.getConservacao() + "', '"
                + AnuncioNovo.getNomeCarro() + "', '"
                + AnuncioNovo.getMarcaCarro() + "', '"
                + AnuncioNovo.getAno() + "', '"
                + AnuncioNovo.getModelo() + "', '"
                + AnuncioNovo.getImagem1() + "', '"
                + AnuncioNovo.getImagem2() + "', '"
                + AnuncioNovo.getPreco() + "', '"
                + AnuncioNovo.getIdUsuario() + "', '"
                + AnuncioNovo.getAnuncioVip() + "');";
        Statement stm = conexao.getConnection().createStatement();
        stm.execute(sql);
        return true;
    }

    public void buscarAnuncio(String idAnuncio) throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        sql = "SELECT * FROM anuncio WHERE idanuncio = '" + idAnuncio + "';";

        Statement stm = conexao.getConnection().createStatement();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next()){
//            String descricao = rs.getString("descricao");
//            return descricao;
//        } else {
//            return 0;
        }
    }
}
