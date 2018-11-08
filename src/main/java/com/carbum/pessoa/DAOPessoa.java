package com.carbum.pessoa;

import com.carbum.ConexaoBanco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOPessoa {
    private ConexaoBanco conexao;
    private String sql;

    public DAOPessoa () throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        conexao = new ConexaoBanco();
    }

    public int buscarPessoaBanco(String email) throws SQLException {

        sql = "SELECT idPessoa FROM pessoa WHERE emaillogin = '" + email + "';";

        Statement stm = conexao.getConnection().createStatement();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next()){
            return rs.getInt("idPessoa");
        } else {
            return 0;
        }
    }

    public boolean inserirPessoaNova(Pessoa pessoa) throws SQLException {
        if (this.buscarPessoaBanco(pessoa.getEmailLogin()) == 0) {
            sql = "INSERT INTO pessoa (nomepessoa, emaillogin, senha, cpf, telefone) VALUES ('"
                    + pessoa.getNome() + "', '"
                    + pessoa.getEmailLogin() + "', '"
                    + pessoa.getSenha() + "', '"
                    + pessoa.getCPF() + "', '"
                    + pessoa.getTelefone() + "');";

            Statement stm = conexao.getConnection().createStatement();
            stm.execute(sql);

            return true;
        } else {
            return false;
        }
    }

    public void inserirTelefone(String telefone, int idPessoa) throws SQLException {
        sql = "INSERT INTO telefone(idpessoa, telefone) VALUES (" + idPessoa+ ", '" + telefone + "');";
        Statement stm = conexao.getConnection().createStatement();
        stm.execute(sql);
    }
}
