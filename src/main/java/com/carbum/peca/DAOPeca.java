package com.carbum.peca;

import com.carbum.ConexaoBanco;

import java.sql.SQLException;
import java.sql.Statement;

public class DAOPeca {
    private ConexaoBanco conexao;
    private String sql;

    public DAOPeca()throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        this.conexao = new ConexaoBanco();
    }

    public ConexaoBanco getConexao() {
        return conexao;
    }

    public boolean inserirPecaAcervo(Peca PecaNova) throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        sql = "Insert into Peca (NomePeca, ParteCarro, descricao, conservacao) values ('"
                + PecaNova.getNomePeca() + "', '"
                + PecaNova.getParteCarro() + "', '"
                + PecaNova.getDescricao() + "', '"
                + PecaNova.getConsevacao() +"');";
        Statement stm = conexao.getConnection().createStatement();
        stm.execute(sql);
        return true;
    }

}
