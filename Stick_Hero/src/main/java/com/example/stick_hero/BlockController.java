package com.example.stick_hero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;

public class BlockController implements Initializable {

    private Rectangle block;
    Random r = new Random();
    private int length = r.nextInt(0, 500);
    private int width = r.nextInt(0, 250);
    private int x=500;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        block.setX(length);
        block.setHeight(204);
        block.setWidth(width);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), e->{
            this.x-=1;
            block.setX(this.x);
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
