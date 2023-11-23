package com.example.stick_hero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class StickController implements Initializable {

    int y=0;

    @FXML
    private Rectangle rectangle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        rectangle.setWidth(5);
        rectangle.setHeight(y);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), e->{
            y+=1;
            rectangle.setHeight(y);
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
