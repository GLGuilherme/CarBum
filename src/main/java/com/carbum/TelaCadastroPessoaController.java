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
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TelaCadastroPessoaController implements Initializable {

    public TextField inputNome, inputCpf, inputUsuario, inputSenha, inputTelefone, inputRua, inputNumero, inputComplemento, inputBairro, inputEstado, inputCidade, inputCep;
    public Button btSalvarPessoa;
    public Button btVoltar;
    public Label erroNome;
    public Label erroCpf;
    public Label erroUsuario;
    public Label erroSenha;
    public Label erroRua;
    public Label erroNumero;
    public Label erroTelefone;
    public Label erroBairro;
    public Label erroCep;
    public Label erroCidade;
    public Label erroEstado;
    @FXML
    private AnchorPane rootPane;

    @FXML
    private void salvarPessoa(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        boolean operacaoCompleta = false;

        String nome = inputNome.getText(),
                cpf = Mascaras.onlyDigitsValue(this.inputCpf),
                email = inputUsuario.getText(),
                senha = inputSenha.getText(),
                rua = inputRua.getText(),
                bairro = inputBairro.getText(),
                numero = inputNumero.getText(),
                telefone = Mascaras.onlyDigitsValue(this.inputTelefone),
                complemento = inputComplemento.getText(),
                cidade = inputCidade.getText(),
                estado = inputEstado.getText(),
                cep = Mascaras.onlyDigitsValue(this.inputCep);


        if (nome.isEmpty()){
            erroNome.setText("Campo obrigatório");
        }else {
            erroNome.setText("");
        }
        if (cpf.length() < 11){
            erroCpf.setText("Campo obrigatório com 11 dígitos");
        }else {
            erroCpf.setText("");
        }
        if (email.isEmpty()){
            erroUsuario.setText("Campo obrigatório");
        }else {
            erroUsuario.setText("");
        }
        if (senha.length() < 4){
            erroSenha.setText("Campo obrigatório com mais de 4 caracteres");
        }else {
            erroSenha.setText("");
        }
        if (rua.isEmpty()){
            erroRua.setText("Campo obrigatório");
        }else {
            erroRua.setText("");
        }
        if (numero.isEmpty()){
            erroNumero.setText("Campo obrigatório");
        }else {
            erroNumero.setText("");
        }
        if (telefone.length() < 11){
            erroTelefone.setText("Campo obrigatório com 11 dígitos");
        }else {
            erroTelefone.setText("");
        }
        if (bairro.isEmpty()){
            erroBairro.setText("Campo obrigatório");
        }else {
            erroBairro.setText("");
        }
        if (cep.length() < 8){
            erroCep.setText("Campo obrigatório com 8 dígitos");
        }else {
            erroCep.setText("");
        }
        if (cidade.isEmpty()){
            erroCidade.setText("Campo obrigatório");
        }else {
            erroCidade.setText("");
        }
        if (estado.isEmpty()){
            erroEstado.setText("Campo obrigatório");
        }else {
            erroEstado.setText("");
        }
        if (nome.isEmpty() || cpf.length() < 11 || email.isEmpty() || senha.length() < 4 || rua.isEmpty() ||
        numero.isEmpty() || telefone.length() < 11 || bairro.isEmpty() || cep.length() < 8 || cidade.isEmpty() ||
        estado.isEmpty()){
            return;
        }

        Pessoa pessoaNova = new Pessoa(null, nome, cpf, email, senha, telefone);
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
            alert.setContentText("Este usuário já está cadastrado no sistema!");

            alert.showAndWait();
        }
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
       /* ValidationSupport validationSupport = new ValidationSupport();
        validationSupport.registerValidator(inputNome, Validator.createEmptyValidator("asdfdfsdf"));
        validationSupport.registerValidator(inputCpf, Validator.createEmptyValidator("safdfasdfasd"));
        validationSupport.registerValidator(inputUsuario, Validator.createEmptyValidator("safdfasdfasd"));
        validationSupport.registerValidator(inputSenha, Validator.createEmptyValidator("safdfasdfasd"));
        validationSupport.registerValidator(inputRua, Validator.createEmptyValidator("safdfasdfasd"));
        validationSupport.registerValidator(inputBairro, Validator.createEmptyValidator("safdfasdfasd"));
        validationSupport.registerValidator(inputNumero, Validator.createEmptyValidator("safdfasdfasd"));
        validationSupport.registerValidator(inputTelefone, Validator.createEmptyValidator("safdfasdfasd"));
        validationSupport.registerValidator(inputCidade, Validator.createEmptyValidator("safdfasdfasd"));
        validationSupport.registerValidator(inputEstado, Validator.createEmptyValidator("safdfasdfasd"));
        validationSupport.registerValidator(inputCep, Validator.createEmptyValidator("safdfasdfasd"));*/
    }
}
