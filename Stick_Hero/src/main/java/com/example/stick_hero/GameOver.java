package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class GameOver{
    private int best_score, curr_score;
    private Image home, restart;
    @FXML
    private Label currentScore;
    @FXML
    private Label bestScore;

    public void go_to_home(ActionEvent event){
        //new Start_screen();
        //to go back to home
    }
    public void restart_game(ActionEvent event){
        //new Game_screen();
        //to restart the game
    }
    public void displayScore(){
        currentScore.setText(String.valueOf(curr_score));
        bestScore.setText(String.valueOf(best_score));
    }

    public static void showGameOverScreen(){
    }

}
