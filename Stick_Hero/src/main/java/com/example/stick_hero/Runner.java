package com.example.stick_hero;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Runner {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void show_Runner() throws IOException {
        root = FXMLLoader.load(getClass().getResource("Runner.fxml"));
        stage = new Stage();
        Scene scene = new Scene(root);
        Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
        stage.getIcons().add(icon);
        stage.setTitle("Stick Hero");
        stage.setScene(scene);
        stage.show();
    }
}
