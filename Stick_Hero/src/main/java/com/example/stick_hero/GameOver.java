package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;

public class GameOver extends Menu{
    private int best_score, curr_score;
    private Image home, restart;

    public GameOver(int cherries, Image background, int best_score, int curr_score, Image home, Image restart) {
        super(cherries, background);
        this.best_score = best_score;
        this.curr_score = curr_score;
        this.home = home;
        this.restart = restart;
    }
    public void go_to_home(ActionEvent event){
        //to go back to home
    }
    public void restart_game(ActionEvent event){
        new Game_screen();
        //to restart the game
    }

}
