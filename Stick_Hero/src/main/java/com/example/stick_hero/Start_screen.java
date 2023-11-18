package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;

public class Start_screen extends Menu{
    private Image volume;
    private Image cherry;
    private Image dummy_avatar;
    private Avatar avatar;

    public Start_screen(int cherries, Image background, Avatar avatar) {
        super(cherries, background);
        this.volume = new Image("volume.png");
        this.cherry = new Image("cherry.png");
        this.dummy_avatar = new Image("hero.png");
        this.avatar = avatar;
    }
    public void run_game(ActionEvent event){
        // when u press start the game_screen is loaded
        new Game_screen(super.getCherries() ,super.getBackground() , avatar);
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
