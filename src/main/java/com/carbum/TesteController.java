package com.carbum;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TesteController implements Initializable {
    public Button btnVenderPeca;
    public StackPane rootPane;
    public Button btnInicio;
    public Button btnMinhaConta;
    public Button btnHistorico;
    public Button btnConfiguracoes;
    public Button btnSair;
    public AnchorPane totalPane;
    public Button btnMeusAnuncios;
    public Button btnVoltar;
    public static String caminho;

    public void handleClicks(ActionEvent actionEvent) {

        if (actionEvent.getSource() == btnInicio){
            rootPane.getChildren().clear();

            try {
                AnchorPane telaInicio = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaInicial.fxml"));

                rootPane.getChildren().setAll(telaInicio);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*if (actionEvent.getSource() == btnMinhaConta){
            rootPane.getChildren().clear();

            try {
                AnchorPane telaCadastroPeca = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaInicial.fxml"));

                rootPane.getChildren().setAll(telaCadastroPeca);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        if (actionEvent.getSource() == btnVenderPeca) {

            rootPane.getChildren().clear();

            try {
                AnchorPane telaVenderPeca = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaCadastroPeca.fxml"));

                rootPane.getChildren().setAll(telaVenderPeca);
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();*/
        }

        if (actionEvent.getSource() == btnMeusAnuncios){
            rootPane.getChildren().clear();

            try {
                AnchorPane telaMeusAnuncios = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaMeusAnuncios.fxml"));

                rootPane.getChildren().setAll(telaMeusAnuncios);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*if (actionEvent.getSource() == btnHistorico){
            rootPane.getChildren().clear();

            try {
                AnchorPane telaCadastroPeca = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaInicial.fxml"));

                rootPane.getChildren().setAll(telaCadastroPeca);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        /*if (actionEvent.getSource() == btnConfiguracoes){
            rootPane.getChildren().clear();

            try {
                AnchorPane telaCadastroPeca = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaInicial.fxml"));

                rootPane.getChildren().setAll(telaCadastroPeca);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        if (actionEvent.getSource() == btnSair){
            totalPane.getChildren().clear();
            rootPane.getChildren().clear();

            try {
                AnchorPane telaLogin = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaLogin.fxml"));

                totalPane.getChildren().setAll(telaLogin);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (actionEvent.getSource() == btnVoltar){
            rootPane.getChildren().clear();

            if (TelaDetalheAnuncioController.caminho.equals(TesteController.caminho)){
                System.out.println(TelaDetalheAnuncioController.caminho);
                try {
                    AnchorPane telaAnterior = (AnchorPane) FXMLLoader.load(getClass()
                            .getResource("/fxml/TelaPecasBuscadas.fxml"));

                    rootPane.getChildren().setAll(telaAnterior);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else{
                try {
                    AnchorPane telaAnterior = (AnchorPane) FXMLLoader.load(getClass()
                            .getResource("/fxml/TelaInicial.fxml"));

                    rootPane.getChildren().setAll(telaAnterior);
                    TelaDetalheAnuncioController.caminho = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rootPane.getChildren().clear();

        try {
            AnchorPane telaInicial = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaInicial.fxml"));

            rootPane.getChildren().setAll(telaInicial);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
