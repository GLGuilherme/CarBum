package Pessoa;

import sample.ConexaoBanco;

import java.sql.Connection;

public class DAOPessoa {
    private ConexaoBanco conexao;
    private String sql;

    public DAOPessoa (){
        conexao = new ConexaoBanco();
    }



}
