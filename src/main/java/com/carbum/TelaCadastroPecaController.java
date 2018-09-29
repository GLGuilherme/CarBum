package com.carbum;


import com.carbum.anuncio.Anuncio;
import com.carbum.anuncio.DAOAnuncio;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TelaCadastroPecaController implements Initializable {

    public TextField inputTitulo;
    public ComboBox<String> inputMarca;
    public ComboBox<String> inputModelo;
    public ComboBox<String> inputAno;
    public ComboBox<String> inputConservacao;
    public TextArea inputDescricao;
    public Button btSalvarPeca;

    private ConexaoBanco conexao;
    private String sql;

    public TelaCadastroPecaController()throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        this.conexao = new ConexaoBanco();
    }

    public ConexaoBanco getConexao() {
        return conexao;
    }

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void salvarPeca(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        boolean operacaoCompleta = false;

        String titulo = inputTitulo.getText();
        String marca = inputMarca.getValue();
        String modelo = inputModelo.getValue();
        String ano = inputAno.getValue();
        String conservacao = inputConservacao.getValue();
        String descricao = inputDescricao.getText();

        Anuncio anuncioNovo = new Anuncio(titulo,"Porta", descricao, conservacao, "Cruze",
                marca, ano, modelo);

        DAOAnuncio daoAnuncio = new DAOAnuncio();
        operacaoCompleta = daoAnuncio.inserirAnuncio(anuncioNovo);

        if (operacaoCompleta) {
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
                    .getResource("/fxml/TelaInicial.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            sql = "SELECT * FROM marca";
            Statement stm = conexao.getConnection().createStatement();
            stm.execute(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                String marca = rs.getString("marca");
                inputMarca.getItems().add(marca);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        try {
            sql = "SELECT * FROM anomodelo";
            Statement stm = conexao.getConnection().createStatement();
            stm.execute(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                String anomodelo = rs.getString("anomodelo");
                inputAno.getItems().add(anomodelo);
                inputModelo.getItems().add(anomodelo);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        try {
            sql = "SELECT * FROM conservacao";
            Statement stm = conexao.getConnection().createStatement();
            stm.execute(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                String conservacao = rs.getString("conservacao");
                inputConservacao.getItems().add(conservacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
