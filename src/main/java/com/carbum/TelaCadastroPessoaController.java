package com.carbum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;

import java.io.IOException;

import com.carbum.pessoa.DAOPessoa;
import com.carbum.pessoa.Pessoa;
import com.carbum.endereco.DAOEndereco;
import com.carbum.endereco.Endereco;

import java.io.IOException;
import java.sql.SQLException;

public class TelaCadastroPessoaController {

    public TextField inputNome, inputCpf, inputEmail, inputDDD, inputTelefone, inputRua, inputNumero, inputComplemento, inputBairro, inputEstado, inputCidade, inputCep;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void salvarPessoa(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        boolean operacaoCompleta = false;

        String nome = inputNome.getText(),
                cpf = inputCpf.getText(),
                email = inputEmail.getText(),
                ddd = inputDDD.getText(),
                telefone = inputTelefone.getText(),
                rua = inputRua.getText(),
                bairro = inputBairro.getText(),
                numero = inputNumero.getText(),
                complemento = inputComplemento.getText(),
                cidade = inputCidade.getText(),
                estado = inputEstado.getText(),
                cep = inputCep.getText();

        Pessoa pessoaNova = new Pessoa(nome, cpf, email, "123456");
        pessoaNova.setEmailLogin(email);

        DAOPessoa daoPessoa = new DAOPessoa();
        operacaoCompleta = daoPessoa.inserirPessoaNova(pessoaNova);
        if (operacaoCompleta) {
            //mensagem de exito
            int idPessoa = daoPessoa.buscarPessoaBanco(pessoaNova.getEmailLogin());
            DAOEndereco daoEndereco = new DAOEndereco();
            Endereco enderecoPessoaNova = new Endereco("Brasil", estado, cidade, rua, numero, bairro, cep, complemento);
            daoEndereco.inserirEndereco(enderecoPessoaNova, idPessoa);

            this.navegaTelaInicial();
        } else {
            //apresentar erro na inserção, pessoa já existe no banco
        }
    }

    @FXML
    public void navegaTelaInicial() throws IOException {
        rootPane.getChildren().clear();
        try {
            AnchorPane telaPecaPesquisas = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaInicial.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
