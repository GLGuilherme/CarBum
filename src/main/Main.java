package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Views/TelaInicial.fxml"));

        Rectangle2D r = Screen.getPrimary().getBounds();
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setTitle("CarBum");
        primaryStage.setScene(new Scene(root, r.getWidth(), r.getHeight()));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}