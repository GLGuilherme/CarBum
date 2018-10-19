package com.carbum;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import org.apache.log4j.Layout;
import sun.plugin2.util.ColorUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.annotation.Inherited;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static com.carbum.TelaCadastroPecaController.decodeToImage;
import static javafx.scene.paint.Color.BLUE;

public class TelaPecasBuscadasController implements Initializable{
    public TextField inputTermoBusca;
    public Button btBuscar;
    public Button btVenderPeca;
    public Button btMinhaConta;
    public GridPane pecasBuscadas = new GridPane();
    public Button button;
    public ScrollPane scrollPane;
    public static String pecaBuscada;

    @FXML
    AnchorPane rootPane;

    private ConexaoBanco conexao;
    private String sql;

    public TelaPecasBuscadasController()throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        this.conexao = new ConexaoBanco();
    }

    public ConexaoBanco getConexao() {
        return conexao;
    }

    public void buscar(ActionEvent actionEvent) {

        try {
            TelaInicialController.pecaBuscada = inputTermoBusca.getText();
            AnchorPane telaPecaPesquisas = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaPecasBuscadas.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void vender(ActionEvent actionEvent) {

        rootPane.getChildren().clear();

        try {
            AnchorPane telaCadastroPeca = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaCadastroPeca.fxml"));

            rootPane.getChildren().setAll(telaCadastroPeca);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void conta(ActionEvent actionEvent) {
        /*rootPane.getChildren().clear();

        try {
            AnchorPane telaPecaPesquisas = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaCadastroPessoa.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scrollPane.setFitToWidth(true);
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setVgrow(Priority.ALWAYS);

        pecasBuscadas.getRowConstraints().addAll(rowConstraints);

        try {

            sql = "SELECT a.partecarro, a.nomecarro, a.marcacarro, a.ano, a.modelo, a.conservacao, a.preco, a.imagem1, e.cidade, e.estado,e.rua, e.bairro, e.numero FROM anuncio a, endereco e WHERE partecarro ~* ? AND a.idpessoa = e.idpessoa";
            PreparedStatement pstatement = conexao.getConnection().prepareStatement(sql);
            pstatement.setString(1, TelaInicialController.pecaBuscada);
            ResultSet rs = pstatement.executeQuery();
            int contC = 0, contR = 0;
            while (rs.next()){
                String partecarro = rs.getString("partecarro");
                String nomecarro = rs.getString("nomecarro");
                String marcacarro = rs.getString("marcacarro");
                String ano = rs.getString("ano");
                String modelo = rs.getString("modelo");
                String conservacao = rs.getString("conservacao");
                String preco = rs.getString("preco");
                String imagem = rs.getString("imagem1");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String rua = rs.getString("rua");
                String bairro = rs.getString("bairro");
                String numero = rs.getString("numero");

                BufferedImage bufferedImage = decodeToImage(imagem);
                Image card = SwingFXUtils.toFXImage(bufferedImage, null );

                ImageView imageView = new ImageView(card);
                imageView.setFitWidth(310);
                imageView.setFitHeight(250);
                imageView.setPreserveRatio(true);

                Label valor;
                if (preco.isEmpty()){
                    valor = new Label("Valor a Combinar");
                    valor.setWrapText(true);
                    valor.setStyle("-fx-background-color: orange");
                    valor.setFont(Font.font(20));
                    valor.setTextAlignment(TextAlignment.LEFT);
                    valor.setAlignment(Pos.TOP_LEFT);
                }else {
                    valor = new Label("R$" + preco);
                    valor.setWrapText(true);
                    valor.setStyle("-fx-background-color: orange");
                    valor.setFont(Font.font(20));
                    valor.setTextAlignment(TextAlignment.LEFT);
                    valor.setAlignment(Pos.TOP_LEFT);
                }

                StackPane stackPane= new StackPane();
                StackPane.setAlignment(valor, Pos.BOTTOM_RIGHT);
                stackPane.getChildren().add(imageView);
                stackPane.getChildren().add(valor);
                stackPane.setStyle("-fx-alignment: top_center");

                Text text = new Text(partecarro + " " + nomecarro + " " + marcacarro + " "
                        + ano + "/" + modelo + " em um " + conservacao + " estado");
                text.setWrappingWidth(280);
                text.setFont(Font.font(20));
                text.setStyle("-fx-fill: white");

                Text textEndereco = new Text("Rua " + rua + ", " + numero+ "\n" + bairro + "\n"
                        + cidade + " - " + estado);
                textEndereco.setWrappingWidth(280);
                textEndereco.setFont(Font.font(20));
                textEndereco.setStyle("-fx-fill: white");

                ImageView iconeDescricao = new ImageView("images/catalogue.png");
                ImageView iconeEndereco = new ImageView("images/digital-map.png");

                HBox hBoxDescricao = new HBox(iconeDescricao, text);
                HBox hBoxEndereco = new HBox(iconeEndereco, textEndereco);
                hBoxEndereco.setMaxWidth(310);
                hBoxDescricao.setCursor(Cursor.HAND);

                FlowPane flowPane = new FlowPane(hBoxDescricao, hBoxEndereco);
                flowPane.setStyle("-fx-background-color: #282828");

                VBox vBox = new VBox(stackPane, flowPane);
                VBox.setVgrow(flowPane, Priority.ALWAYS);
                vBox.setMaxHeight(Double.MAX_VALUE);
                vBox.setSpacing(-1);

                GridPane.setConstraints(vBox, contC, contR);
                pecasBuscadas.getChildren().addAll(vBox);
                rowConstraints.setMaxHeight(Double.MAX_VALUE);
                contC++;
                if (contC > 2){
                    contC = 0;
                    contR++;
                    pecasBuscadas.getRowConstraints().addAll(rowConstraints);
                }
            }
            if(contC == 0){
                pecasBuscadas.getRowConstraints().removeAll(rowConstraints);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @FXML
    public void onEnter(ActionEvent ae){

        try {
            TelaInicialController.pecaBuscada = inputTermoBusca.getText();
            AnchorPane telaPecaPesquisas = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaPecasBuscadas.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
