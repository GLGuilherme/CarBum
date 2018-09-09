package main.Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaInicialController  {

   @FXML
    private AnchorPane rootPane;


   @FXML
    public void buscar(ActionEvent event) throws IOException {
       AnchorPane pane = FXMLLoader.load(getClass().getResource("Views/TelaPeçasPesquisadas.fxml"));
       rootPane.getChildren().setAll(pane);
    }

    @FXML
    public void conta(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("fxml/TelaPeçasPesquisadas.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    public void vender(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Views/TelaCadastroPessoa.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
