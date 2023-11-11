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
            new game_over().show_game_over();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}