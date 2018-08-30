package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.TelaInicial.TelaInicialController;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TelaInicial/TelaInicial.fxml"));
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("CarBum");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
