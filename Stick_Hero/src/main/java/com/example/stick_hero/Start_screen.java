package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;

public class Start_screen extends Menu{
    private Image start_button;
    private Image volume;
    private Image cherry;
    private Image dummy_avatar;
    private Avatar avatar;

    public Start_screen(int cherries, Image background, Image start_button, Image volume, Image cherry, Image dummy_avatar, Avatar avatar) {
        super(cherries, background);
        this.start_button = start_button;
        this.volume = volume;
        this.cherry = cherry;
        this.dummy_avatar = dummy_avatar;
        this.avatar = avatar;
    }
    public void run_game(ActionEvent event){
        // when u press start the game_screen is loaded
    }
    public void show_tutorial(ActionEvent event){
        // the labels for tutorials that are going to pop up
    }
    public void buy_cherries(ActionEvent event){
        //is going to show dummy menu for buying cherries
    }
    public void buy_avatar(ActionEvent event){
        // to buy avatar with cherries
    }
    public void mute(ActionEvent event){
        // is going to mute sound
    }


}
