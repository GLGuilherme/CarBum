package com.carbum;

import com.carbum.anuncio.DAOAnuncio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TelaDetalheAnuncioController {
    public static String idAnuncioClicado;

    @FXML
    private AnchorPane rootPane;


    @FXML
    public void navegaTelaAnterior() throws IOException {
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
