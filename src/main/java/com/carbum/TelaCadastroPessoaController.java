package com.carbum;

import com.carbum.auxiliares.Mascaras;
import com.carbum.endereco.DAOEndereco;
import com.carbum.endereco.Endereco;
import com.carbum.pessoa.DAOPessoa;
import com.carbum.pessoa.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TelaCadastroPessoaController implements Initializable {

    public TextField inputNome, inputCpf, inputEmail, inputSenha, inputTelefone, inputRua, inputNumero, inputComplemento, inputBairro, inputEstado, inputCidade, inputCep;
    public Button btSalvarPessoa;
    public Button btVoltar;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void salvarPessoa(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        boolean operacaoCompleta = false;

        String nome = inputNome.getText(),
                cpf = inputCpf.getText(),
                email = inputEmail.getText(),
                senha = inputSenha.getText(),
                rua = inputRua.getText(),
                bairro = inputBairro.getText(),
                numero = inputNumero.getText(),
                complemento = inputComplemento.getText(),
                cidade = inputCidade.getText(),
                estado = inputEstado.getText(),
                cep = inputCep.getText();

        Pessoa pessoaNova = new Pessoa(nome, cpf, email, senha);
        pessoaNova.setEmailLogin(email);

        DAOPessoa daoPessoa = new DAOPessoa();
        operacaoCompleta = daoPessoa.inserirPessoaNova(pessoaNova);
        if (operacaoCompleta) {
            //mensagem de exito
            int idPessoa = daoPessoa.buscarPessoaBanco(pessoaNova.getEmailLogin());
            DAOEndereco daoEndereco = new DAOEndereco();
            Endereco enderecoPessoaNova = new Endereco("Brasil", estado, cidade, rua, numero, bairro, cep, complemento);
            daoEndereco.inserirEndereco(enderecoPessoaNova, idPessoa);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro de pessoa");
            alert.setHeaderText(null);
            alert.setContentText("Pessoa cadastrada com sucesso!");

            alert.showAndWait();
            this.navegaTelaInicial();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pessoa já existente");
            alert.setHeaderText(null);
            alert.setContentText("Este e-mail já está cadastrado no sistema!");

            alert.showAndWait();
        }
        getValores();
    }

    @FXML
    public void navegaTelaInicial() throws IOException {
        rootPane.getChildren().clear();
        try {
            AnchorPane telaLogin = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaLogin.fxml"));

            rootPane.getChildren().setAll(telaLogin);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Mascaras.cpfField(this.inputCpf);
        Mascaras.cepField(this.inputCep);
        Mascaras.foneField(this.inputTelefone);
        Mascaras.numericField(this.inputNumero);
    }

    public void getValores(){
        System.out.println("CPF: " + Mascaras.onlyDigitsValue(this.inputCpf));
    }
}
