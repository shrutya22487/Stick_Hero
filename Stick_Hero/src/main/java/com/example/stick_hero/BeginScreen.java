package com.example.stick_hero;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class BeginScreen {
    Scene scene;
    Parent root;

    public void createProfile(EventHandler event){
        //Profile profile = new Profile();
    }
    public void viewProfile(EventHandler event){
    }
    public void profileSelect(EventHandler event){
        //new Start_screen();
    }
    public void exit(EventHandler event) {
    }
    public void show_begin_screen( Stage stage ) throws IOException {
        root = FXMLLoader.load(getClass().getResource("BeginScreen.fxml"));
        scene = new Scene(root);
        Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
        stage.getIcons().add(icon);
        stage.setTitle("Stick Hero");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();

    }

}
