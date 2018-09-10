package main.Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;

import java.io.IOException;

public class TelaInicialController  {

   @FXML
    private AnchorPane rootPane;
   private Scene scene;


   @FXML
    public void buscar(ActionEvent event) throws IOException {
       rootPane.getChildren().clear();

       try {
           AnchorPane telaPecaPesquisas = FXMLLoader.load(getClass()
                   .getResource("../Views/TelaPecasPesquisadas.fxml"));

           rootPane.getChildren().setAll(telaPecaPesquisas);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    @FXML
    public void conta(ActionEvent event) throws IOException {
        rootPane.getChildren().clear();

        try {
            AnchorPane telaPecaPesquisas = FXMLLoader.load(getClass()
                    .getResource("../Views/TelaCadastroPessoa.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void vender(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Views/TelaCadastroPessoa.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
