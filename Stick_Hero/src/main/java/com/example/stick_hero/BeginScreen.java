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
import javafx.scene.image.ImageView;
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
import java.util.Random;

public class BeginScreen {
    @FXML
    ImageView bg;
    public void random_background(){
        Random random = new Random();
        int r = random.nextInt(0,3);
        switch (r) {
            case 1:
                bg.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\bg1.png"));
                break;
            case 2:
                bg.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\bg2.png"));
                break;
            case 3:
                bg.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\bg3.png"));
                break;
        }
    }

    @FXML
    public void new_game(ActionEvent event) throws IOException{
        try {
            Stage stage = Main.stage;
            FXMLLoader fxml_loader =  new FXMLLoader(getClass().getResource("Start_screen.fxml"));
            Scene scene = new Scene( fxml_loader.load() );
            Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
            Start_screen ss = fxml_loader.getController();
            ss.random_background();
            stage.setResizable(false);
            stage.getIcons().add(icon);
            stage.setTitle("Stick Hero");
//            stage.setFullScreen(true);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
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
        Main.stage.close();
    }
}
