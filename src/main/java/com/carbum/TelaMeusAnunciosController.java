package com.carbum;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.carbum.TelaCadastroPecaController.decodeToImage;

public class TelaMeusAnunciosController implements Initializable {
    public ScrollPane scrollPane;
    public GridPane pecasBuscadas;
    public AnchorPane rootPane;
    public TextField inputTermoBusca;
    public Button btBuscar;
    public static String busca = "";

    private ConexaoBanco conexao;
    private String sql;

    public TelaMeusAnunciosController()throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        this.conexao = new ConexaoBanco();
    }

    public ConexaoBanco getConexao() {
        return conexao;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scrollPane.setFitToWidth(true);
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setVgrow(Priority.ALWAYS);

        pecasBuscadas.getRowConstraints().addAll(rowConstraints);

        try {

            sql = "SELECT a.idanuncio, a.partecarro, a.nomecarro, a.marcacarro, a.ano, a.modelo, a.conservacao, a.preco, a.imagem1, e.cidade, e.estado,e.rua, e.bairro, e.numero FROM anuncio a, endereco e WHERE a.partecarro ~* ? AND a.idpessoa = ? AND a.idpessoa = e.idpessoa";
            PreparedStatement pstatement = conexao.getConnection().prepareStatement(sql);
            pstatement.setString(1, TelaMeusAnunciosController.busca);
            pstatement.setInt(2, LoginController.idUsuario);
            ResultSet rs = pstatement.executeQuery();
            int contC = 0, contR = 0;
            while (rs.next()){
                int idAnuncio = rs.getInt("idanuncio");
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
                imageView.setFitWidth(315);
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

                HBox hBoxStackPane = new HBox(stackPane);
                HBox.setHgrow(stackPane, Priority.ALWAYS);
                hBoxStackPane.setStyle("-fx-background-color: black");
                hBoxStackPane.setCursor(Cursor.HAND);

                Text text = new Text(partecarro + " " + marcacarro + " " + nomecarro + " "
                        + ano + "/" + modelo + " em um " + conservacao + " estado");
                text.setWrappingWidth(275);
                text.setFont(Font.font(20));
                text.getStyleClass().add("textDescricao");
                text.setCursor(Cursor.HAND);

                Text textEndereco = new Text("Rua " + rua + ", " + numero+ "\n" + bairro + "\n"
                        + cidade + " - " + estado);
                textEndereco.setWrappingWidth(281);
                textEndereco.setFont(Font.font(17));
                textEndereco.setStyle("-fx-fill: white");
                textEndereco.setCursor(Cursor.HAND);

                /*javafx.scene.control.TextArea textArea = new TextArea("Rua " + rua + ", " + numero+ " \n" + bairro + " \n"
                        + cidade + " - " + estado);
                textArea.getStyleClass().add("textEndereco");
                textArea.setEditable(false);
                textArea.setWrapText(true);
                textArea.setFont(Font.font(17));
                textArea.setMaxWidth(276);
                textArea.setPrefHeight(textEndereco.getLayoutBounds().getHeight() + (textEndereco.getLayoutBounds().getHeight() * 35.5/100));
                System.out.println(textArea.getPrefHeight());*/

                ImageView iconeDescricao = new ImageView("images/catalogue.png");
                ImageView iconeEndereco = new ImageView("images/digital-map.png");

                HBox hBoxDescricao = new HBox(iconeDescricao, text);
                hBoxDescricao.setAlignment(Pos.CENTER_LEFT);
                hBoxDescricao.setMaxWidth(315);
                hBoxDescricao.setSpacing(10);

                HBox hBoxEndereco = new HBox(iconeEndereco, textEndereco);
                hBoxEndereco.setAlignment(Pos.CENTER_LEFT);
                hBoxEndereco.setMaxWidth(315);
                hBoxEndereco.setSpacing(10);
                hBoxEndereco.setStyle("-fx-background-color: #343434");

                FlowPane flowPane = new FlowPane(hBoxDescricao, hBoxEndereco);
                flowPane.setMaxHeight(hBoxDescricao.getHeight() + hBoxEndereco.getHeight());
                flowPane.setVgap(15);
                flowPane.setStyle("-fx-background-color: #282828");

                /*WebView webView = new WebView();
                final WebEngine webEngine = webView.getEngine();
                webEngine.load("https://www.google.com.br/maps");
                webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                        if (newValue == Worker.State.SUCCEEDED){
                            System.out.println("entrou");
                        }
                    }
                });*/

                VBox vBox = new VBox(hBoxStackPane, flowPane);
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
                text.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        try {
                            TelaDetalheAnuncioController.idAnuncioClicado = idAnuncio;
                            AnchorPane telaDetalheAnuncio = (AnchorPane) FXMLLoader.load(getClass()
                                    .getResource("/fxml/TelaDetalheAnuncio.fxml"));

                            rootPane.getChildren().setAll(telaDetalheAnuncio);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

                imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        try {
                            TelaDetalheAnuncioController.idAnuncioClicado = idAnuncio;
                            AnchorPane telaDetalheAnuncio = (AnchorPane) FXMLLoader.load(getClass()
                                    .getResource("/fxml/TelaDetalheAnuncio.fxml"));

                            rootPane.getChildren().setAll(telaDetalheAnuncio);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            if(contC == 0){
                pecasBuscadas.getRowConstraints().removeAll(rowConstraints);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void onEnter(ActionEvent actionEvent) {
        acaoBuscar();
    }

    public void buscar(ActionEvent actionEvent) {

       acaoBuscar();
    }

    public void acaoBuscar(){
        try {
            rootPane.getChildren().clear();
            TelaMeusAnunciosController.busca = inputTermoBusca.getText();
            AnchorPane telaPecaPesquisas = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaMeusAnuncios.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
