package sample.Controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;

public class TelaInicialController  {



    @FXML
    private AnchorPane rootPane;
    private Scene scene;



   @FXML
    private void buscar(ActionEvent event) throws IOException {
       /*AnchorPane pane = FXMLLoader.load(getClass().getResource("fxml/TelaPeçasPesquisadas.fxml"));
       rootPane.getChildren().setAll(pane);*/
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("fxml/TelaPeçasPesquisadas.fxml"));
       rootPane = loader.load();
       this.scene = new Scene(this.rootPane);
   }
}
