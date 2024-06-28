package com.example.stick_hero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;

public class BlockController implements Initializable {
    Random r = new Random();
    private int length = r.nextInt(10, 600);
    private int width = r.nextInt(10, 250);
    private int x=500;
    @FXML
    private Rectangle blockNew;
    private Rectangle blockOld;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        blockNew.setHeight(204);
        blockNew.setX(1000);
        blockNew.setY(300);
        blockNew.setWidth(width);
        blockNew.setFill(Color.BLACK);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e->{
            this.x-=1;
            blockNew.setX(this.x);
        }));

        timeline.setCycleCount(length);
        timeline.play();
    }
}