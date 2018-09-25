package com.carbum;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;

import java.io.IOException;

import java.io.IOException;
import java.sql.SQLException;

public class TelaCadastroPecaController {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void salvarPeca(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        boolean operacaoCompleta = false;

        AnchorPane pane = FXMLLoader.load(getClass().getResource("fxml/TelaCadastroPeca.fxml"));
        rootPane.getChildren().setAll(pane);


        if (operacaoCompleta) {
            //mensagem de exito


            this.navegaTelaInicial();

        } else {
            //apresentar erro na inserção, pessoa já existi no banco
        }
    }

    @FXML
    public void navegaTelaInicial() throws IOException {
        rootPane.getChildren().clear();

        try {
            AnchorPane telaPecaPesquisas = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaInicial.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
