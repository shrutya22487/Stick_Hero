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
    private Image volume;
    private Image cherry;
    private Image dummy_avatar;
    @FXML
    public void run_game(ActionEvent event) throws IOException {
        load_fxml("Game_screen2.fxml");
//        stickController2.curr_score.setText(String.valueOf(get_profile().getCurr_score())); StickController2 stickController2 = (StickController2)
    }

    @Override
    public void go_back(ActionEvent event) throws IOException {
        profile_select ps = (profile_select) load_fxml("profile_select.fxml");
        ps.check_files();
    }
    @FXML
    public void buy_cherries(ActionEvent event) throws IOException {
        load_fxml("Buy_Berries.fxml");
    }
    @FXML
    public void save_game(ActionEvent event) {
        System.out.println(this.getSave_slot());
        switch (this.getSave_slot()) {
            case 1:
                System.out.println(get_profile().getCurr_score());
                Profile.serializeProfile(get_profile(), "game_1.txt");
                break;
            case 2:
                System.out.println(get_profile().getCurr_score());
                Profile.serializeProfile(get_profile(), "game_2.txt");
                break;
            case 3:
                Profile.serializeProfile(get_profile(), "game_3.txt");
                break;
        }
    }


}
