package com.carbum;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
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

    public void handleClicks(ActionEvent actionEvent) {

        if (actionEvent.getSource() == btnInicio){
            rootPane.getChildren().clear();

            try {
                AnchorPane telaCadastroPeca = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaInicial.fxml"));

                rootPane.getChildren().setAll(telaCadastroPeca);
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
                AnchorPane telaCadastroPeca = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaCadastroPeca.fxml"));

                rootPane.getChildren().setAll(telaCadastroPeca);
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();*/
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

            try {
                AnchorPane telaCadastroPeca = (AnchorPane) FXMLLoader.load(getClass()
                        .getResource("/fxml/TelaLogin.fxml"));

                totalPane.getChildren().setAll(telaCadastroPeca);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void onEnter(ActionEvent actionEvent) {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootPane.getChildren().clear();

        try {
            AnchorPane telaCadastroPeca = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaInicial.fxml"));

            rootPane.getChildren().setAll(telaCadastroPeca);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
