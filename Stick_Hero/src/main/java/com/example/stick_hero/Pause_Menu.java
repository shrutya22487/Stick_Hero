package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Pause_Menu extends Menu {

    @FXML
    public void continue_game(ActionEvent event) {

    }

    @FXML
    public void save_game() {

    }
    @FXML
    public void exit() {
        Main.stage.close();
    }
}
