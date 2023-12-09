package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class profile_select extends Menu {
    @FXML
    Button button_profile_1;
    @FXML
    Button button_profile_2;
    @FXML
    Button button_profile_3;
    @FXML
    public  void open_profile_1(ActionEvent event) throws IOException {
        File file = new File("game_1.txt");
        if (file.exists()) {
            this.set_save_slot(1);

            this.set_profile(Profile.deserializeProfile("game_1.txt"));
            load_fxml("Start_screen.fxml");
        } else {
            Profile new_profile = new Profile();
            this.set_profile(new_profile);
            this.set_save_slot(1);
            load_fxml("Start_screen.fxml");
        }
    }
    @FXML
    public  void open_profile_2(ActionEvent event) throws IOException {
        File file = new File("game_2.txt");
        if (file.exists()) {
            this.set_save_slot(2);
            this.set_profile(Profile.deserializeProfile("game_2.txt"));
            load_fxml("Start_screen.fxml");
        } else {
            Profile new_profile = new Profile();
            this.set_profile(new_profile);
            this.set_save_slot(2);
            load_fxml("Start_screen.fxml");
        }
    }

    @Override
    public void go_back(ActionEvent event) throws IOException {
        this.set_profile(new Profile());
        BeginScreen bs = (BeginScreen) load_fxml("BeginScreen.fxml");
    }

    @FXML
    public  void open_profile_3(ActionEvent event) throws IOException {
        File file = new File("game_3.txt");
        if (file.exists()) {
            this.set_save_slot(3);
            this.set_profile(Profile.deserializeProfile("game_3.txt"));
            load_fxml("Start_screen.fxml");
        } else {
            Profile new_profile = new Profile();
            this.set_profile(new_profile);
            this.set_save_slot(3);
            load_fxml("Start_screen.fxml");
        }
    }


    public void check_files(){
        File file = new File("game_1.txt");
        if (file.exists()) button_profile_1.setText("Game_1");
        else button_profile_1.setText("New Game");
        file = new File("game_2.txt");
        if (file.exists()) button_profile_2.setText("Game_2");
        else button_profile_2.setText("New Game");
        file = new File("game_3.txt");
        if (file.exists()) button_profile_3.setText("Game_3");
        else button_profile_3.setText("New Game");
    }
}
