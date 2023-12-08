package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.io.IOException;

public class GameOver extends Menu{
    private int best_score, curr_score;
    private Image home, restart;
    @FXML
    private Label currentScore;
    @FXML
    private Label BestScore;
    @FXML
    Label cherry_count;
    @FXML
    public void go_to_home(ActionEvent event) throws IOException {
        load_fxml("Start_screen.fxml");

    }
    @FXML
    public void restart_game(ActionEvent event) throws IOException {
        load_fxml("Game_screen2.fxml");
    }
    public void displayScore(){
        currentScore.setText(String.valueOf(curr_score));
        BestScore.setText(String.valueOf(best_score));
    }

}
