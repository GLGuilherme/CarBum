package com.carbum;


import com.carbum.anuncio.Anuncio;
import com.carbum.anuncio.DAOAnuncio;
import com.carbum.auxiliares.Mascaras;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.apache.commons.lang.ObjectUtils;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import org.postgresql.util.Base64;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class TelaCadastroPecaController implements Initializable {

    public ComboBox<String> inputMarca;
    public ComboBox<String> inputModelo;
    public ComboBox<String> inputAno;
    public ComboBox<String> inputConservacao;
    public ComboBox<String> inputNomeCarro;
    public ComboBox<String> inputPeca;
    public TextArea inputDescricao;
    public Button btSalvarPeca;
    public ImageView imagemPeca1;
    public ImageView imagemPeca2;
    public String imagem1;
    public String imagem2;
    public TextField inputPreco;
    public WebView webView;
    public Label erroPeca;


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

        String marca = inputMarca.getValue();
        String modelo = inputModelo.getValue();
        String ano = inputAno.getValue();
        String conservacao = inputConservacao.getValue();
        String nomeCarro = inputNomeCarro.getValue();
        String descricao = inputDescricao.getText();
        String peca = inputPeca.getValue();
        String preco = inputPreco.getText();

        if (peca == null){
            erroPeca.setText("Campo peça obrigatório");
        }else {
            erroPeca.setText("");
        }
        if (peca == null){
            return;
        }

        Anuncio anuncioNovo = new Anuncio(peca, descricao, conservacao, nomeCarro,
                marca, ano, modelo, imagem1, imagem2, preco);

        DAOAnuncio daoAnuncio = new DAOAnuncio();
        operacaoCompleta = daoAnuncio.inserirAnuncio(anuncioNovo);

        if (operacaoCompleta) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro de Peça");
            alert.setHeaderText(null);
            alert.setContentText("Peça cadastrada com sucesso!");
            alert.showAndWait();
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

    public ComboBox<String> getInputMarca() {

        try {

            sql = "SELECT DISTINCT marca FROM nomecarroemarca";
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

        return inputMarca;
    }

    public ComboBox<String> getInputNomeCarro() {

        try {

            sql = "SELECT nomecarro FROM nomecarroemarca";
            PreparedStatement stm = conexao.getConnection().prepareStatement(sql);
            //stm.setString(1, String.valueOf(getInputMarca()));
            ResultSet resultSet = stm.executeQuery();
            /*Statement stm = conexao.getConnection().createStatement();
            stm.execute(sql);
            ResultSet rs = stm.executeQuery(sql);*/
            while (resultSet.next()) {
                String nomeCarro = resultSet.getString("nomecarro");
                inputNomeCarro.getItems().add(nomeCarro);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return inputNomeCarro;
    }


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Mascaras.monetaryField(this.inputPreco);
        getInputMarca();
        getInputNomeCarro();

        /*inputPreco.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\,]\\d{0,2})?")) {
                    inputPreco.setText(oldValue);
                }
            }
        });*/

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

        try {
            sql = "SELECT * FROM partecarro";
            Statement stm = conexao.getConnection().createStatement();
            stm.execute(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                String parteCarro = rs.getString("partecarro");
                inputPeca.getItems().add(parteCarro);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    @FXML
    public String selecionarImagem1(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();

        try {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Selecionar Imagem");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpeg", "*.jpg"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));

            File arq = fileChooser.showOpenDialog(stage);

            if (arq != null) {

                Image image = new Image(arq.toURI().toURL().toExternalForm());

                imagemPeca1.setImage(image);

                String encodefile = null;
                FileInputStream fileInputStream = new FileInputStream(arq);

                byte[] bytes = new byte[(int)arq.length()];
                fileInputStream.read(bytes);
                encodefile = Base64.encodeBytes(bytes).toString();

                imagem1 = encodefile;
            }

        }catch (Exception e){
            System.err.println(e);
        }

        return imagem1;

    }

    public String selecionarImagem2(MouseEvent mouseEvent) {

        Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();

        try {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Selecionar Imagem");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpeg", "*.jpg"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));

            File arq = fileChooser.showOpenDialog(stage);

            if (arq != null) {

                Image image = new Image(arq.toURI().toURL().toExternalForm());

                imagemPeca2.setImage(image);

                String encodefile = null;
                FileInputStream fileInputStream = new FileInputStream(arq);

                byte[] bytes = new byte[(int)arq.length()];
                fileInputStream.read(bytes);
                encodefile = Base64.encodeBytes(bytes).toString();

                imagem2 = encodefile;
            }

        }catch (Exception e){
            System.err.println(e);
        }

        return imagem2;

    }

    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }




}
