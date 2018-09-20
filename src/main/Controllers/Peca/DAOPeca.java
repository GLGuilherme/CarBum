package main.Controllers.Peca;

import main.ConexaoBanco;

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

    public void inserirPecaAcervo(Peca PecaNova) throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        sql = "Insert into Peca (NomePeca, MarcaPeca, ParteCarro) values ('" + PecaNova.getNomePeca() + "', '" + PecaNova.getMarca() + "', '" + PecaNova.getParteCarro() + "');";
        Statement stm = conexao.getConnection().createStatement();
        stm.execute(sql);
    }

}
