package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class BeginScreen {

    @FXML
    public void createProfile(ActionEvent event){
        //Profile profile = new Profile();
    }

    @FXML
    public void choose_profile(ActionEvent event){
        try{
            Stage stage = Main.stage;
            FXMLLoader fxml_loader =  new FXMLLoader(getClass().getResource("profile_select.fxml"));
            Scene scene = new Scene( fxml_loader.load() );
            Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
            profile_select profileSelect = fxml_loader.getController();
            profileSelect.check_files();
            stage.getIcons().add(icon);
            stage.setTitle("Stick Hero");
            stage.setFullScreen(true);
            stage.setScene(scene);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    public void exit(ActionEvent event) {
    }
}
