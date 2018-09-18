package Endereco;

import main.ConexaoBanco;

import java.sql.SQLException;
import java.sql.Statement;

public class DAOEndereco {
    private ConexaoBanco conexao;
    private String sql;

    public DAOEndereco() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.conexao = new ConexaoBanco();
    }

    public void inserirEndereco(Endereco endereco, int IdPessoa) throws SQLException {
        sql = "Insert into Endereco (IdPessoa, Pais, Estado, Cidade, CEP, Rua, Bairro, Numero, Complemento, LinkGoogleMaps) values (" +
                IdPessoa + ", '" + endereco.getPais() + "', '" + endereco.getEstado() + "', '" + endereco.getCidade() + "', '" +
                endereco.getCEP() + "', '" + endereco.getRua() + "', '" + endereco.getBairro() + "', '" + endereco.getNumero() + "', '" +
                endereco.getComplemento() + "', '" + endereco.getLinkGoogleMaps() + "');";

        Statement stm = conexao.getConnection().createStatement();
        stm.execute(sql);
    }
}
