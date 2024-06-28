package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
//Singleton class as only 1 begin screen can exist
public class BeginScreen extends Menu {
    private static BeginScreen beginScreen= null;

    private BeginScreen(Profile profile) {
        this.set_profile(profile);
    }
    public static BeginScreen getInstance(Profile profile){
        if (beginScreen == null) beginScreen = new BeginScreen(profile);
        return beginScreen;
    }
// creating a new profile
    @FXML
    public void new_game(ActionEvent event) throws IOException {
        this.set_profile(new Profile());
        profile_select ps = (profile_select) load_fxml("profile_select.fxml");
        ps.check_files();
    }

//choose a previously created/saved profile
    @FXML
    public void choose_profile(ActionEvent event) throws IOException {
        this.set_profile(new Profile());
        profile_select ps = (profile_select) load_fxml("profile_select.fxml");
        ps.check_files();
    }

    @FXML
    public void exit(ActionEvent event) {
        Main.stage.close();
    }
}
