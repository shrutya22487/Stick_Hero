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
    Stage stage;
    Scene scene;
    Parent root;

    Profile profile;
    boolean profile_1, profile_2, profile_3;
    @FXML
    Button button_profile_1;
    @FXML
    Button button_profile_2;
    @FXML
    Button button_profile_3;
    @FXML
    public void createProfile(EventHandler event){
        //Profile profile = new Profile();
    }
    @FXML
    public  void open_profile_1(ActionEvent event){
        File file = new File("game-" + 1 + ".dat");
        if (file.exists()) {
            ObjectInputStream in;
            try {
                in = new ObjectInputStream(Files.newInputStream(Paths.get("game1.dat")));
                profile = (Profile) in.readObject();
                in.close();
                new Game_screen(profile).show_game_screen(stage);
                //pass to game screen here
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void check_files(){
        File file = new File("game-" + 1 + ".dat");
        if (file.exists()) button_profile_1.setText("Game_1");
        else button_profile_1.setText("New Game");
        file = new File("game-" + 2 + ".dat");
        if (file.exists()) button_profile_2.setText("Game_1");
        else button_profile_2.setText("New Game");
        file = new File("game-" + 3 + ".dat");
        if (file.exists()) button_profile_3.setText("Game_1");
        else button_profile_3.setText("New Game");
    }
    @FXML
    public void choose_profile(EventHandler event){
        try{
            root = FXMLLoader.load(getClass().getResource("BeginScreen.fxml"));
            scene = new Scene(root);
            Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
            stage.getIcons().add(icon);
            check_files();
            stage.setTitle("Stick Hero");
            stage.setFullScreen(true);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    public void exit(EventHandler event) {
    }
    public void show_begin_screen( Stage stage ) throws IOException {
        this.stage = stage;
        root = FXMLLoader.load(getClass().getResource("BeginScreen.fxml"));
        scene = new Scene(root);
        Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
        this.stage.getIcons().add(icon);
        this.stage.setTitle("Stick Hero");
        this.stage.setFullScreen(true);
        this.stage.setScene(scene);
        this.stage.show();
    }
}
