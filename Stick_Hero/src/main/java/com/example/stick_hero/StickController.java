package com.example.stick_hero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class StickController implements Initializable{

    private int y1=0;
    private int y2=204;
    private double angle=0;
    private int travel=0;
    private int fall=646;
    private int pressedFrequency=0;
    private Image image1 = new Image("C:\\Users\\ASUS\\Desktop\\AP_Project\\Stick_Hero\\src\\main\\resources\\com\\example\\stick_hero\\run1.png");
    private Image image2 = new Image("C:\\Users\\ASUS\\Desktop\\AP_Project\\Stick_Hero\\src\\main\\resources\\com\\example\\stick_hero\\run2.png");
    @FXML
    private Rectangle rectangle;
    private Timeline timeline1, timeline2, timeline3, timeline4;
    private TranslateTransition translateTransition;
    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        rectangle.setWidth(5);
        rectangle.setHeight(0);
        rectangle.setX(0);
        imageView.setX(0);
        imageView.setY(646);

        timeline1 = new Timeline(new KeyFrame(Duration.millis(5), e->{
            this.y1+=1;
            this.y2-=1;
            rectangle.setHeight(this.y1);
            rectangle.setY(this.y2);
        }));

        timeline1.setCycleCount(Animation.INDEFINITE);

        timeline2 = new Timeline(new KeyFrame(Duration.millis(10), e->{
            this.angle+=1;
            rectangle.setRotate(angle);
        }));

        timeline2.setCycleCount(90);

        translateTransition = new TranslateTransition(Duration.seconds(1), rectangle);

        timeline3 = new Timeline(new KeyFrame(Duration.millis(50), e->{
            this.travel+=9;
            if (travel%18==0)
            {
                imageView.setImage(image2);
            } else {
                imageView.setImage(image1);
            }
            imageView.setX(this.travel);
        }));

        timeline4 = new Timeline(new KeyFrame(Duration.millis(1000), e->{
            this.fall+=1;
            imageView.setY(this.fall);
        }));

        timeline4.setCycleCount(Animation.INDEFINITE);
    }

    public void runWin(){
        int a = 276/9;
        timeline3.setCycleCount(a);
        timeline3.play();
    }
    public void runLoose(){
        int a = (this.y1)/9;
        timeline3.setCycleCount(a);
        timeline3.play();
        timeline3.setOnFinished(e->timeline4.play());
    }
    public void stickGrow(ActionEvent event){
        if (pressedFrequency==0)
        {
            timeline2.stop();
            timeline1.play();
            pressedFrequency++;
        } else if (pressedFrequency==1) {
            timeline1.stop();
            timeline2.play();
            translateTransition.setByX(y1/2);
            translateTransition.setByY(y1/2);
            translateTransition.play();
            pressedFrequency++;
            System.out.println(y1);
            if (y1>154 && y1<276){
                System.out.println("You Win");
                translateTransition.setOnFinished(e->runWin());
            } else {
                System.out.println("You loose");
                translateTransition.setOnFinished(e->runLoose());
            }
        }
    }
}
