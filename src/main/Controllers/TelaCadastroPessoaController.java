package main.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;

import java.io.IOException;

import main.Controllers.Pessoa.DAOPessoa;
import main.Controllers.Pessoa.Pessoa;
import main.Controllers.Endereco.DAOEndereco;
import main.Controllers.Endereco.Endereco;

import java.io.IOException;
import java.sql.SQLException;

public class TelaCadastroPessoaController {

    public TextField inputNome, inputCpf, inputEmail, inputDDD, inputTelefone, inputRua, inputNumero, inputComplemento, inputBairro, inputEstado, inputCidade, inputCep;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void salvarPessoa(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        boolean operacaoCompleta = false;

        String Nome = inputNome.getText(),
                CPF = inputCpf.getText(),
                Email = inputEmail.getText(),
                DDD = inputDDD.getText(),
                Telefone = inputTelefone.getText(),
                Rua = inputRua.getText(),
                Bairro = inputBairro.getText(),
                Numero = inputNumero.getText(),
                Complemento = inputComplemento.getText(),
                Cidade = inputCidade.getText(),
                Estado = inputEstado.getText(),
                CEP = inputCep.getText();

        Pessoa pessoaNova = new Pessoa();
        pessoaNova.setNome(inputNome.getText());
        pessoaNova.setCPF(inputCpf.getText());
        pessoaNova.setEmailLogin(inputEmail.getText());
        //pessoaNova.setSenha(); Precisa inserir campo senha na tela
        DAOPessoa inserirPessoa = new DAOPessoa();

        operacaoCompleta = inserirPessoa.inserirPessoaNova(pessoaNova);
        if (operacaoCompleta) {
            //mensagem de exito
            int IdPessoa;
            IdPessoa = inserirPessoa.buscarPessoaBanco(pessoaNova.getEmailLogin());
            DAOEndereco inserirEndereco = new DAOEndereco();
            Endereco enderecoPessoaNova = new Endereco("Brasil", Estado, Cidade, Rua, Numero, Bairro, CEP, Complemento);
            inserirEndereco.inserirEndereco(enderecoPessoaNova, IdPessoa);

            this.navegaTelaInicial();

        } else {
            //apresentar erro na inserção, pessoa já existi no banco
        }
    }

    @FXML
    public void navegaTelaInicial() throws IOException {
        rootPane.getChildren().clear();

        try {
            AnchorPane telaPecaPesquisas = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("../Views/TelaInicial.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
