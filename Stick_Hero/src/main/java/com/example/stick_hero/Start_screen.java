package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Random;

public class Start_screen extends Menu{
    @FXML
    public void run_game(ActionEvent event) throws IOException {
        StickController2 stickController2 = (StickController2) load_fxml("Game_screen2.fxml");
        stickController2.curr_score.setText(String.valueOf(get_profile().getCurr_score()));
    }

    @Override
    public void go_back(ActionEvent event) throws IOException {
        profile_select ps = (profile_select) load_fxml("profile_select.fxml");
        ps.check_files();
    }
}
