package sample.Controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

public class TelaInicialController  {

   @FXML
    private AnchorPane rootPane;


   @FXML
    private void buscar(ActionEvent event) throws IOException {
       AnchorPane pane = FXMLLoader.load(getClass().getResource("fxml/TelaPeçasPesquisadas.fxml"));
       rootPane.getChildren().setAll(pane);

   }
}
