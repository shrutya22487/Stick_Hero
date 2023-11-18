package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Game_screen extends Menu{
    private int curr_score;
    @FXML
    private Rectangle rectangle = new Rectangle(2, 2, Color.BLACK);
    private int y;

    public Game_screen(int cherries, Image background, Avatar avatar) {
        super(cherries, background);
        this.curr_score = 0;
    }
    public void generate_random_block(){
        // generates random block to step onto
    }
    public void generate_random_cherry(){
        //generates random cherry in path
    }
    public void generate_stick(ActionEvent event){
        //to generate stick
    }
    public boolean death(){
        //will instantiate the game_over screen if player dies
    }
    public void run(){
    }
    //put random generating blocks and cherries here
}
