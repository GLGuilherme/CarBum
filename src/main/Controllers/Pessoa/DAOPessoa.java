package main.Controllers.Pessoa;

import main.ConexaoBanco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOPessoa {
    private ConexaoBanco conexao;
    private String sql;

    public DAOPessoa () throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.conexao = new ConexaoBanco();
    }

    public int buscarPessoaBanco(String email) throws SQLException {

        sql = "SELECT IdPessoa from Email where emailpessoal = " + email;

        Statement stm = conexao.getConnection().createStatement();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next()){
            return rs.getInt("IdPessoa");
        }
        else {
            return 0;
        }
    }

    public boolean inserirPessoaNova(Pessoa pessoa) throws SQLException {
        int codigo;

        if ( this.buscarPessoaBanco(pessoa.getEmailLogin()) == 0) {
            sql = "Insert into Pessoa(NomePessoa, EmailLogin, Senha) values " +
                    "('" + pessoa.getNome() + "'," + "'" + pessoa.getEmailLogin() + "'," + "'" + pessoa.getSenha() + "')";
            Statement stm = conexao.getConnection().createStatement();
            stm.execute(sql);

            codigo = buscarPessoaBanco(pessoa.getEmailLogin());
            sql = "INSERT Into Email(IdPessoa, EmailPessoal) values (" + codigo + ", '" + pessoa.getEmailLogin() + "');";
            stm.execute(sql);
            return true;
        } else {
            return false;
        }
    }

    public void inserirTelefone(String telefone, int IdPessoa) throws SQLException {
        sql = "Insert into Telefone (IdPessoa, Telefone) values (" + IdPessoa + ", '" + telefone + "');";
        Statement stm = conexao.getConnection().createStatement();
        stm.execute(sql);
    }


}
