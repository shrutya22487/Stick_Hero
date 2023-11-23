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
import java.net.URL;

public class TestRunner extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Game_screen.fxml"));
            Scene scene = new Scene(root);
            Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
            stage.getIcons().add(icon);
            stage.setTitle("Stick Hero");
            stage.setFullScreen(true);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}