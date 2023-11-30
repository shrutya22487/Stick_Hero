package com.example.stick_hero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

import java.net.URL;
import java.util.ResourceBundle;

public class StickController implements Initializable{

    Random r = new Random();
    private int length;
    private int width;
    private int y1=0;
    private int y2=0;
    private double angle=0;
    private int posBlockAfterX=100;
    private int travel1=0;
    private int travel2=0;
    private int fall=646;
    private int blockAfterTravel=1000;
    private int pressedFrequency=0;
    private Image image1 = new Image("C:\\Users\\ASUS\\Desktop\\AP_Project\\Stick_Hero\\src\\main\\resources\\com\\example\\stick_hero\\run1.png");
    private Image image2 = new Image("C:\\Users\\ASUS\\Desktop\\AP_Project\\Stick_Hero\\src\\main\\resources\\com\\example\\stick_hero\\run2.png");
    @FXML
    private Rectangle rectangle;
    private Timeline timeline1, timeline2, timeline3_1, timeline3_2, timeline4, timeline5, timeline6;
    private TranslateTransition translateTransition;
    @FXML
    private ImageView imageView;
    @FXML
    private Rectangle blockPrevious;
    @FXML
    private Rectangle blockAfter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        width = r.nextInt(10, 200);
        length = r.nextInt((int) blockPrevious.getX()+50, 500-width);
        blockAfter.setX(1000);
        blockAfter.setWidth(width);

        rectangle.setWidth(5);
        rectangle.setHeight(0);
        rectangle.setX(blockPrevious.getX()+blockPrevious.getWidth());
        rectangle.setY(blockPrevious.getY()-rectangle.getHeight());
        imageView.setX(0);

        y2 = (int) blockPrevious.getY();

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

        timeline3_1 = new Timeline(new KeyFrame(Duration.millis(50), e->{
            this.travel1+=9;
            if (travel1%18==0)
            {
                imageView.setImage(image2);
            } else {
                imageView.setImage(image1);
            }
            imageView.setX(this.travel1);
        }));

        timeline3_2 = new Timeline(new KeyFrame(Duration.millis(50), e->{
            this.travel2+=9;
            if (travel2%18==0)
            {
                imageView.setImage(image2);
            } else {
                imageView.setImage(image1);
            }
            imageView.setX(this.travel2);
        }));

        timeline4 = new Timeline(new KeyFrame(Duration.millis(10), e->{
            this.fall+=1;
            imageView.setY(this.fall);
        }));

        timeline4.setCycleCount(Animation.INDEFINITE);

        timeline5 = new Timeline(new KeyFrame(Duration.millis(10), e->{
            this.blockAfterTravel-=10;
            blockAfter.setX(this.blockAfterTravel);
        }));

        timeline5.setCycleCount((1000-length)/10);
        timeline5.play();

        timeline6 = new Timeline(new KeyFrame(Duration.millis(10), e->{
            blockAfter.setX(blockAfter.getX()-1);
            blockPrevious.setX(blockPrevious.getX()-1);
            rectangle.setX(rectangle.getX()-1);
            imageView.setX(imageView.getX()-1);
        }));

        timeline6.setCycleCount(this.length+10);
    }

    public void runWin(){
        int a = (int) (blockAfter.getX()+blockAfter.getWidth())/9;
        timeline3_1.setCycleCount(a);
        timeline3_1.play();
        timeline3_1.setOnFinished(e->timeline6.play());
        timeline3_1.setOnFinished(e-> {
            try {
                levelChange();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    public void runLoose(){
        int a = (this.y1)/9;
        timeline3_2.setCycleCount(a);
        timeline3_2.play();
        timeline3_2.setOnFinished(e->timeline4.play());
    }

    public void levelChange() throws IOException {
        timeline6.play();
        Parent root = FXMLLoader.load(getClass().getResource("Game_screen.fxml"));
        Scene scene = new Scene(root);
        TestRunner.stage.setScene(scene);
        TestRunner.stage.show();
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
            if (y1>blockAfter.getX()-blockPrevious.getWidth() && y1<blockAfter.getX()-blockPrevious.getWidth()+blockAfter.getWidth()){
                System.out.println("You Win");
                translateTransition.setOnFinished(e->runWin());

            } else {
                System.out.println("You loose");
                translateTransition.setOnFinished(e->runLoose());
                GameOver.showGameOverScreen();
            }
        }
    }
}
