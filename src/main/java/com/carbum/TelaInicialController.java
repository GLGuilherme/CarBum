package com.carbum;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;

public class TelaInicialController{
    public Button btBuscar;
    public TextField inputTermoBusca;
    public static String pecaBuscada;
    public static String caminho = "/fxml/TelaInicial.fxml";

    @FXML
    private AnchorPane rootPane;
    private Scene scene;

//    private static final Logger log = LoggerFactory.getLogger(TelaInicialController.class);
//
//    @FXML private TextField firstNameField;
//    @FXML private TextField lastNameField;
//    @FXML private Label messageLabel;
//
//    public void buscar() {
//
//        String firstName = firstNameField.getText();
//        String lastName = lastNameField.getText();
//
//        StringBuilder builder = new StringBuilder();
//
//        if (!StringUtils.isEmpty(firstName)) {
//            builder.append(firstName);
//        }
//
//        if (!StringUtils.isEmpty(lastName)) {
//            if (builder.length() > 0) {
//                builder.append(" ");
//            }
//            builder.append(lastName);
//        }
//
//        if (builder.length() > 0) {
//            String name = builder.toString();
//            log.debug("Saying hello to " + name);
//            messageLabel.setText("Hello " + name);
//        } else {
//            log.debug("Neither first name nor last name was set, saying hello to anonymous person");
//            messageLabel.setText("Hello mysterious person");
//        }
//    }


    @FXML
    public void buscar(ActionEvent event) throws IOException {
        rootPane.getChildren().clear();

        try {
            pecaBuscada = inputTermoBusca.getText();
            AnchorPane telaPecaPesquisas = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaPecasBuscadas.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onEnter(ActionEvent ae) {
        try {
            TelaInicialController.pecaBuscada = inputTermoBusca.getText();
            AnchorPane telaPecaPesquisas = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaPecasBuscadas.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
