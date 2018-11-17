package com.carbum;

import com.carbum.anuncio.DAOAnuncio;
import com.carbum.auxiliares.Mascaras;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.carbum.TelaCadastroPecaController.decodeToImage;

public class TelaDetalheAnuncioController implements Initializable {
    public static int idAnuncioClicado;
    public ImageView imagemPeca2;
    public ImageView imagemPeca1;
    public Button btVoltar;
    public Label peca;
    public Label estadoPeca;
    public Label carro;
    public Label ano;
    public Label modelo;
    public Label preco;
    public Label descricao;
    public Label anunciante;
    public Label telefone;
    public Label email;
    public Label marca;
    public HBox hbox;
    public HBox hbox1;
    public static String caminho = "/fxml/TelaDetalheAnuncio.fxml";
    public Button buttonSlide;
    public int cont;
    public String imagem1, imagem2;
    public ImageView next;
    public ImageView previous;
    public Button favoritos;
    public ImageView estrela;

    @FXML
    private AnchorPane rootPane;

    private ConexaoBanco conexao;
    private String sql;

    public TelaDetalheAnuncioController()throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        this.conexao = new ConexaoBanco();
    }

    public ConexaoBanco getConexao() {
        return conexao;
    }


    @FXML
    public void navegaTelaAnterior() throws IOException {
        rootPane.getChildren().clear();

        try {
            AnchorPane telaPecaPesquisas = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaPecasBuscadas.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TesteController.caminho = caminho;

        next.setVisible(false);
        previous.setVisible(false);

        try {
            sql = "SELECT a.partecarro, a.descricao, a.conservacao, a.nomecarro, a.marcacarro, a.ano, a.modelo, a.imagem1, a.imagem2, a.preco, p.nomepessoa, p.telefone FROM anuncio a, pessoa p WHERE a.idanuncio = ? AND a.idpessoa = p.idpessoa";
            PreparedStatement pstatement = conexao.getConnection().prepareStatement(sql);
            pstatement.setInt(1, idAnuncioClicado);
            ResultSet rs = pstatement.executeQuery();

            while (rs.next()){
                String parteCarro = rs.getString("partecarro");
                String descricaoPeca = rs.getString("descricao");
                String conservacao = rs.getString("conservacao");
                String nomeCarro = rs.getString("nomecarro");
                String marcaCarro = rs.getString("marcacarro");
                String anoCarro = rs.getString("ano");
                String modeloCarro = rs.getString("modelo");
                imagem1 = rs.getString("imagem1");
                imagem2 = rs.getString("imagem2");
                String precoPeca = rs.getString("preco");
                String nomePessoa = rs.getString("nomepessoa");
                String telefonePessoa = rs.getString("telefone");

                bufferedImage(imagem1, imagemPeca1);

                StackPane stackPane= new StackPane();
                stackPane.getChildren().add(imagemPeca1);
                stackPane.getChildren().add(next);
                stackPane.getChildren().add(previous);
                StackPane.setAlignment(next, Pos.CENTER_RIGHT);
                StackPane.setAlignment(previous, Pos.CENTER_LEFT);
                stackPane.setStyle("-fx-alignment: center");

                hbox.getChildren().add(stackPane);
                HBox.setHgrow(stackPane, Priority.ALWAYS);
                hbox.setStyle("-fx-background-color: black");

                peca.setText(parteCarro);
                descricao.setText(descricaoPeca);
                estadoPeca.setText(conservacao);
                carro.setText(nomeCarro);
                marca.setText(marcaCarro);
                ano.setText(anoCarro);
                modelo.setText(modeloCarro);
                preco.setText(precoPeca);
                anunciante.setText(nomePessoa);
                StringBuilder telefone1 = null;
                for (int i = 0; i < 11; i++){
                    if (i == 0){
                        telefone1 = new StringBuilder("(" + telefonePessoa.charAt(i));
                    }else if (i == 1){
                        telefone1.append(telefonePessoa.charAt(i)).append(")");
                    }else if (i == 6){
                        telefone1.append(telefonePessoa.charAt(i)).append("-");
                    }else {
                        telefone1.append(telefonePessoa.charAt(i));
                    }
                }
                telefone.setText(telefone1.toString());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            sql = "SELECT f.idpessoa, f.idanuncio FROM favorito f WHERE f.idpessoa = ? AND f.idanuncio = ?";
            PreparedStatement pstatement = conexao.getConnection().prepareStatement(sql);
            pstatement.setInt(1, LoginController.idUsuario);
            pstatement.setInt(2, idAnuncioClicado);
            ResultSet rs = pstatement.executeQuery();

            if (rs.next()){
                Image image = new Image("fxml/images/star.png");
                estrela.setImage(image);
                favoritos.setText("Remover dos Favoritos");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void bufferedImage(String string, ImageView imageView){
        BufferedImage bufferedImage = decodeToImage(string);
        Image card = SwingFXUtils.toFXImage(bufferedImage, null );

        imageView.setImage(card);
    }

    public void slideFrente(MouseEvent mouseEvent) {
        cont++;
        bufferedImage(imagem2, imagemPeca1);
        if (cont > 1){
            bufferedImage(imagem1, imagemPeca1);
            cont = 0;
        }
    }

    public void slideTras(javafx.scene.input.MouseEvent mouseEvent) {
        if (cont == 1){
            bufferedImage(imagem1, imagemPeca1);
            cont--;
        }else if (cont == 0){
            bufferedImage(imagem2, imagemPeca1);
            cont = 1;
        }
    }

    public void showImages(MouseEvent mouseEvent) {
        next.setVisible(true);
        previous.setVisible(true);
    }

    public void hideImages(MouseEvent mouseEvent) {
        next.setVisible(false);
        previous.setVisible(false);
    }

    public void adicionarFavoritos(ActionEvent actionEvent) {

        if (favoritos.getText().equals("Adicionar aos Favoritos")){
            try {
                sql = "INSERT INTO favorito (idpessoa, idanuncio) VALUES (?,?)";
                PreparedStatement pstatement = conexao.getConnection().prepareStatement(sql);
                pstatement.setInt(1, LoginController.idUsuario);
                pstatement.setInt(2, idAnuncioClicado);
                pstatement.execute();
                favoritos.setText("Remover dos Favoritos");
                Image image = new Image("fxml/images/star.png");
                estrela.setImage(image);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }else {
            try {
                sql = "DELETE FROM favorito WHERE favorito.idpessoa = ? AND  favorito.idanuncio = ?";
                PreparedStatement pstatement = conexao.getConnection().prepareStatement(sql);
                pstatement.setInt(1, LoginController.idUsuario);
                pstatement.setInt(2, idAnuncioClicado);
                pstatement.execute();
                favoritos.setText("Adicionar aos Favoritos");
                Image image = new Image("fxml/images/starDash.png");
                estrela.setImage(image);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
}
