package main.Controllers;


import main.Endereco.DAOEndereco;
import main.Endereco.Endereco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.Pessoa.DAOPessoa;
import main.Pessoa.Pessoa;


import java.io.IOException;
import java.sql.SQLException;

public class TelaCadastroPessoaController  {

    public TextField inputNome;
    public TextField inputCpf;
    public TextField inputEmail;
    public TextField inputDDD;
    public TextField inputTelefone;
    public TextField inputRua;
    public TextField inputNumero;
    public TextField inputComplemento;
    public TextField inputBairro;
    public TextField inputEstado;
    public TextField inputCidade;
    public TextField inputCep;

    @FXML
    private AnchorPane rootPane;


    @FXML
    private void salvarPessoa(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        boolean operacaoCompleta = false;

        AnchorPane pane = FXMLLoader.load(getClass().getResource("fxml/TelaCadastroPessoa.fxml"));
        rootPane.getChildren().setAll(pane);
        String Nome = inputNome.getText();
        String CPF = inputCpf.getText();
        String Email = inputEmail.getText();
        String DDD = inputDDD.getText();
        String Telefone = inputTelefone.getText();
        String Rua = inputRua.getText();
        String Bairro = inputBairro.getText();
        String Numero = inputNumero.getText();
        String Complemento = inputComplemento.getText();
        String Cidade = inputCidade.getText();
        String Estado = inputEstado.getText();
        String CEP = inputCep.getText();

        Pessoa pessoaNova = new Pessoa();
        pessoaNova.setNome(inputNome.getText());
        pessoaNova.setCPF(inputCpf.getText());
        pessoaNova.setEmailLogin(inputEmail.getText());
        //pessoaNova.setSenha(); Precisa inserir campo senha na tela
        DAOPessoa inserirPessoa = new DAOPessoa();


        operacaoCompleta = inserirPessoa.inserirPessoaNova(pessoaNova);
        if(operacaoCompleta){
            //mensagem de exito
            int IdPessoa;
            IdPessoa = inserirPessoa.buscarPessoaBanco(pessoaNova.getEmailLogin());
            DAOEndereco inserirEndereco = new DAOEndereco();
            Endereco enderecoPessoaNova =  new Endereco("Brasil", Estado, Cidade, Rua, Numero, Bairro, CEP, Complemento);
            inserirEndereco.inserirEndereco(enderecoPessoaNova, IdPessoa);
        }
        else{
            //apresentar erro na inserção, pessoa já existi no banco
        }

    }
}
