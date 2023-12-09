package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;

public class BeginScreen extends Menu {
    @FXML
    public void new_game(ActionEvent event) throws IOException{
        this.set_profile(new Profile());
        profile_select ps = (profile_select)load_fxml("profile_select.fxml");
        ps.check_files();
    }
    @FXML
    public void choose_profile(ActionEvent event) throws IOException {
        this.set_profile(new Profile());
        profile_select ps = (profile_select)load_fxml("profile_select.fxml");
        ps.check_files();
    }
    @FXML
    public void exit(ActionEvent event) {
        Main.stage.close();
    }
}
