package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Random;

public class Pause_Menu extends Menu {

    @FXML
    public void continue_game(ActionEvent event) throws IOException {
        StickController2 stickController2 = (StickController2) load_fxml("Game_screen2.fxml");
        stickController2.cherry_count.setText(String.valueOf(get_cherries()));
    }

    @FXML
    public void save_game() {

    }
    @FXML
    public void exit() {
        Main.stage.close();
    }
}
