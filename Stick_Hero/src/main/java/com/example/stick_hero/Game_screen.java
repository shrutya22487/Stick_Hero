package com.example.stick_hero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class Game_screen extends Menu {
    private int curr_score;
    int i=0;

    public Game_screen(int cherries, Image background, Avatar avatar) {
        super(cherries, background);
        this.curr_score = 0;
    }

    public void generate_random_block(ActionEvent event){
        // generates random block to step onto
    }
    public void generate_random_cherry(ActionEvent event){
        //generates random cherry in path
    }
    public void generate_stick(ActionEvent event){
        //to generate stick
    }
    public boolean death(ActionEvent event){
        //will instantiate the game_over screen if player dies
        //new GameOver();
        return true;
    }
    public void run(ActionEvent event){
    }
    //put random generating blocks and cherries here
}
