package com.example.stick_hero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class StickController implements Initializable{

    private int y1=0;
    private int y2=204;
    private int pressedFrequency=0;
    private Rectangle block;
    @FXML
    private Rectangle rectangle;
    private Timeline timeline;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        rectangle.setWidth(5);
        rectangle.setHeight(0);
        rectangle.setY(204);
        rectangle.setX(0);

        timeline = new Timeline(new KeyFrame(Duration.millis(5), e->{
            this.y1+=1;
            this.y2-=1;
            rectangle.setHeight(this.y1);
            rectangle.setY(this.y2);
        }));
    }

    public void stickGrow(ActionEvent event){
        if (pressedFrequency==0)
        {
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
            pressedFrequency++;
        } else {
            timeline.stop();
            pressedFrequency=0;
            System.out.println(y1);
            if (y1>276 && y1<276+122){
                System.out.println("You Win");
            } else {
                System.out.println("You loose");
            }
        }
    }
}
