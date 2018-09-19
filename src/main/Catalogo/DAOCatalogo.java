package main.Catalogo;

import main.ConexaoBanco;

import java.sql.SQLException;

public class DAOCatalogo {
    private ConexaoBanco conexao;
    private String sql;

    public DAOCatalogo() throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        this.conexao = new ConexaoBanco();
    }
}
