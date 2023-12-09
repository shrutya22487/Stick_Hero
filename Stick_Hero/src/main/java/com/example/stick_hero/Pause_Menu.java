package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Random;

public class Pause_Menu extends Menu {
    @FXML
    Label currscore;
    @FXML
    Label best_score;

    @FXML
    public void continue_game(ActionEvent event) throws IOException {
        StickController2 stickController2 = (StickController2) load_fxml("Game_screen2.fxml");
        stickController2.curr_score.setText(String.valueOf(get_profile().getCurr_score()));
        stickController2.cherry_count.setText(String.valueOf(get_cherries()));
    }

    @FXML
    public void save_game(ActionEvent event) {
        System.out.println(this.getSave_slot());
        switch (this.getSave_slot()) {
            case 1:
//                System.out.println(get_profile().getCurr_score());
                Profile.serializeProfile(get_profile(), "game_1.txt");
                break;
            case 2:
//                System.out.println(get_profile().getCurr_score());
                Profile.serializeProfile(get_profile(), "game_2.txt");
                break;
            case 3:
                Profile.serializeProfile(get_profile(), "game_3.txt");
                break;
        }
    }
    @FXML
    public void go_to_home(ActionEvent event) throws IOException {
        load_fxml("Start_screen.fxml");
    }
}
