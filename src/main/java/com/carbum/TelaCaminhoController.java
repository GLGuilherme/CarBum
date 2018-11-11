package com.carbum;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaCaminhoController implements Initializable {
    //public WebView maps;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        /*final WebEngine webEngine = maps.getEngine();
        webEngine.load("https://www.google.com.br/maps/dir/Casa/" + TelaPecasBuscadasController.caminho);
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                if (newValue == Worker.State.SUCCEEDED){
                    System.out.println("entrou");
                }
            }
        });*/
    }
}
