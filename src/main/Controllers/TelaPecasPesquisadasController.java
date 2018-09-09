package main.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TelaPecasPesquisadasController {

    @FXML
    private AnchorPane rootPane;


    @FXML
    public void buscar(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("fxml/TelaPeçasPesquisadas.fxml"));
        rootPane.getChildren().setAll(pane);
    }

}
