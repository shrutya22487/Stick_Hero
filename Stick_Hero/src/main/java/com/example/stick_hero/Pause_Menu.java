package com.example.stick_hero;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Pause_Menu {
    @FXML
    ImageView bg;
    public void set_background(String filepath){
        bg.setImage(new Image(filepath));
    }
    @FXML
    public void continue_game(int currscore, int cherries) {

    }

    @FXML
    public void save_game() {

    }
    @FXML
    public void exit() {
        Main.stage.close();
    }
}
