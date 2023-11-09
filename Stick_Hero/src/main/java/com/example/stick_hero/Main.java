package com.example.stick_hero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent fxml_root = FXMLLoader.load(getClass().getResource("Game_over.fxml"));
            Group root = new Group();
            Scene scene = new Scene(fxml_root, Color.WHITE);
            Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
            stage.getIcons().add(icon);
            stage.setWidth(500);
            stage.setHeight(800);
            stage.setTitle("Stick Hero");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}