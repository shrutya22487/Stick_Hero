package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;

public class Game_screen extends Menu{
    private Avatar avatar;
    private int curr_score;

    public Game_screen(int cherries, Image background, Avatar avatar) {
        super(cherries, background);
        this.avatar = avatar;
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
    public void death(){
        //will instantiate the game_over screen if player dies
    }
    //put random generating blocks and cherries here


}
