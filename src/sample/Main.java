package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage ) throws Exception{
        Parent root = load(getClass().getResource("Controllers/fxml/TelaInicial.fxml"));
        //primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setTitle("CarBum");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
