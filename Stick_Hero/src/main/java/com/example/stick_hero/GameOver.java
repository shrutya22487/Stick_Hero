package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class GameOver extends Menu{
    private int temp_currscore;
    private Image home, restart;
    @FXML
    private Label currentScore;
    @FXML
    private Label BestScore;

    public Label getCherry_count() {
        return cherry_count;
    }

    public void setCherry_count(Label cherry_count) {
        this.cherry_count = cherry_count;
    }

    @FXML
    private Label cherry_count;
    @FXML
    public void save_game() {
        switch (super.getSave_slot()) {
            case 1:
                System.out.println(get_profile().getHighScore());
                Profile.serializeProfile(get_profile(), "game_1.txt");
                break;
            case 2:
                System.out.println(get_profile().getHighScore());
                Profile.serializeProfile(get_profile(), "game_2.txt");
                break;
            case 3:
                Profile.serializeProfile(get_profile(), "game_3.txt");
                break;
        }
    }
    @FXML
    public void go_to_home(ActionEvent event) throws IOException {
        get_profile().setCurr_score(0);
        load_fxml("Start_screen.fxml");
    }
    @FXML
    public void restart_game(ActionEvent event) throws IOException {
        get_profile().setCurr_score(0);
        load_fxml("Game_screen2.fxml");
    }
    public void displayScore(int curr_score, int best_score){
        temp_currscore = curr_score;
        currentScore.setText(String.valueOf(curr_score));
        BestScore.setText(String.valueOf(best_score));
    }
    @FXML
    public void revive(ActionEvent event) throws IOException {
        if (get_cherries() >= 2) {
            get_profile().setCurr_score(temp_currscore);
            get_profile().setCherries(get_cherries() - 2);
            StickController2 stickController2 = (StickController2) load_fxml("Game_screen2.fxml");
            stickController2.curr_score.setText(String.valueOf(temp_currscore));
            stickController2.cherry_count.setText(String.valueOf(get_cherries()));
        }
    }

}
