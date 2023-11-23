package com.example.stick_hero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class Game_screen extends Menu implements Initializable {
    private int curr_score;
    @FXML
    private Rectangle rectangle = new Rectangle(2, 2, Color.BLACK);
    private int y;
    @FXML
    private Text text;

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
        //new GameOver();
        return true;
    }
    public void run(){
    }
    //put random generating blocks and cherries here

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AtomicInteger i= new AtomicInteger();
        text.setText(String.valueOf(i.get()));
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e->{
            i.addAndGet(1);
            text.setText(String.valueOf(i.get()));
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
