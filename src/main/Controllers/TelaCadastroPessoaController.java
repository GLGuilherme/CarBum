package main.Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

public class TelaCadastroPessoaController  {

    @FXML
    private AnchorPane rootPane;


    @FXML
    private void salvarPessoa(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("fxml/TelaCadastroPessoa.fxml"));
        rootPane.getChildren().setAll(pane);

    }
}
