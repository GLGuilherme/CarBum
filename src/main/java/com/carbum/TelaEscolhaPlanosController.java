package com.carbum;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class TelaEscolhaPlanosController {
    public Button btnSimples;
    public Button btnAvancado;
    public Button btnSuper;
    public AnchorPane rootPane;
    public int simples = 50;
    public int avancado = 90;
    public int top = 200;
    ButtonType sim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
    ButtonType nao = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

    private ConexaoBanco conexao;
    private String sql;

    public TelaEscolhaPlanosController()throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        this.conexao = new ConexaoBanco();
    }

    public ConexaoBanco getConexao() {
        return conexao;
    }

    public void escolhaPlano(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnSimples){
            Alert alert = new Alert(Alert.AlertType.WARNING, "", sim, nao);
            alert.setTitle("Aquisição de Plano Simples");
            alert.setHeaderText(null);
            alert.setContentText("Se você confirmar este plano, só poderá escolher outro quando esse acabar!\nTem certeza?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.orElse(nao) == sim){

                adicionarPlano(simples);
                telaInicial();

            }else {
                telaPlanos();
            }

        }

        if (actionEvent.getSource() == btnAvancado){

            Alert alert = new Alert(Alert.AlertType.WARNING, "", sim, nao);
            alert.setTitle("Aquisição de Plano Avancado");
            alert.setHeaderText(null);
            alert.setContentText("Se você confirmar este plano, só poderá escolher outro quando esse acabar!\nTem certeza?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.orElse(nao) == sim){

                adicionarPlano(avancado);
                telaInicial();

            }else {
                telaPlanos();
            }

        }

        if (actionEvent.getSource() == btnSuper){

            Alert alert = new Alert(Alert.AlertType.WARNING, "", sim, nao);
            alert.setTitle("Aquisição de Plano Super");
            alert.setHeaderText(null);
            alert.setContentText("Se você confirmar este plano, só poderá escolher outro quando esse acabar!\nTem certeza?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.orElse(nao) == sim){

                adicionarPlano(top);
                telaInicial();

            }else {
                telaPlanos();
            }
        }
    }

    public void adicionarPlano(int qtdAnuncio){

        try {
            sql = "SELECT p.idpessoa, p.qtdanuncio FROM plano p WHERE p.idpessoa = ?";
            PreparedStatement pstatement = conexao.getConnection().prepareStatement(sql);
            pstatement.setInt(1, LoginController.idUsuario);
            ResultSet rs = pstatement.executeQuery();

            if (rs.next()){
                int qtd = rs.getInt("qtdanuncio");

                if (qtd > 0){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Falha");
                    alert.setHeaderText(null);
                    alert.setContentText("Você já possui um plano!");
                    alert.showAndWait();
                }else {
                    try {
                        sql = "UPDATE plano SET qtdanuncio = ? WHERE idpessoa = ?";
                        PreparedStatement statement = conexao.getConnection().prepareStatement(sql);
                        statement.setInt(1, qtdAnuncio);
                        statement.setInt(2, LoginController.idUsuario);
                        statement.execute();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Sucesso");
                        alert.setHeaderText(null);
                        alert.setContentText("Plano cadastrado com sucesso!");
                        alert.showAndWait();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }else {

                try {
                    sql = "INSERT INTO plano (idpessoa, qtdanuncio) VALUES (?,?)";
                    PreparedStatement statement = conexao.getConnection().prepareStatement(sql);
                    statement.setInt(1, LoginController.idUsuario);
                    statement.setInt(2, qtdAnuncio);
                    statement.execute();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Sucesso");
                    alert.setHeaderText(null);
                    alert.setContentText("Plano cadastrado com sucesso!");
                    alert.showAndWait();
                }catch (SQLException e){
                    e.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Falha");
                    alert.setHeaderText(null);
                    alert.setContentText("Houve um erro ao escolher o plano, tente novamente!");
                    alert.showAndWait();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Falha");
            alert.setHeaderText(null);
            alert.setContentText("Houve um erro ao escolher o plano, tente novamente!");
            alert.showAndWait();
        }
    }

    public void telaInicial(){
        rootPane.getChildren().clear();
        try {
            AnchorPane telaInicio = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaInicial.fxml"));

            rootPane.getChildren().setAll(telaInicio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void telaPlanos(){
        rootPane.getChildren().clear();
        try {
            AnchorPane telaInicio = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaEscolhaPlanos.fxml"));

            rootPane.getChildren().setAll(telaInicio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
